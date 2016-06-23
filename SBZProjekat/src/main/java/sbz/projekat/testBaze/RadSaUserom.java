package sbz.projekat.testBaze;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sbz.projekat.entity.User;
import sbz.projekat.entity.User.Uloga;
import sbz.projekat.service.UserService;

@Controller
@RequestMapping(value="/api/radSaUserom")
public class RadSaUserom {
	
	@Autowired
	private UserService us;
	
	@RequestMapping(value="/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(){
		
		System.out.println("USAO");
	
		Uloga kupac = Uloga.KUPAC;
		Uloga menadzer = Uloga.MENADZER;
		Uloga prodavac = Uloga.PRODAVAC;
				
		
		User u1 = new User("korisnik1","ime1","prezime1","sifra", kupac, null, null);
		User u2 = new User("korisnik2","ime2","prezime2","sifra", kupac, null, null);
		User u3 = new User("korisnik3","ime3","prezime3","sifra", menadzer, null, null);
		User u4 = new User("korisnik4","ime4","prezime4","sifra", prodavac, null, null);
		User u5 = new User("korisnik5","ime5","prezime5","sifra", prodavac, null, null);
		
		us.saveUser(u1);
		us.saveUser(u2);
		us.saveUser(u3);
		us.saveUser(u4);
		us.saveUser(u5);
		
		HttpHeaders headers = new HttpHeaders();
		
		return new ResponseEntity(headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> get()
	{ 
		List<User> users = us.getAll();
		for(int i=0; i<users.size();i++) {
			System.out.println("-------------------------------------");
			System.out.println(users.get(i).getKorisnickoIme());
		}
		if (users == null) {
		
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/removeAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> removeAll()
	{ 
		List<User> users = us.getAll();
		if (users == null) {
		
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		while (users.size()>0)
		{
			int index = users.size() - 1;
			us.removeUser(users.get(index));
			users.remove(index);
			System.out.println("OSTALO JOS: "+users.size());
		}
		return new ResponseEntity(users, HttpStatus.OK);
	
	}
	
	@RequestMapping(value="/pretraga", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> pretraga()
	{ 
		System.out.println("USAO");
		User user = null;
		
		user = us.findByUsername("korisnik1");
		System.out.println("PRONADJEN KORISNIK: " + user.getKorisnickoIme());
		
		return new ResponseEntity(user, HttpStatus.OK);
	
	}
	
	

}
