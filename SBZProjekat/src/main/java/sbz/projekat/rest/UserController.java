package sbz.projekat.rest;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import sbz.projekat.entity.Book;
import sbz.projekat.entity.User;
import sbz.projekat.entity.UserAccount;
import sbz.projekat.service.UserAccountService;
import sbz.projekat.service.UserService;

@Controller
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserAccountService userAccountService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody User user, UriComponentsBuilder uriBuilder){
		
		if(user.getUloga() == User.Uloga.KUPAC) {
			UserAccount account = new UserAccount();
			userAccountService.saveUserAccount(account);
			user.setUserAccount(account);
		}
	
		userService.saveUser(user);
		String korisnickoIme = user.getKorisnickoIme();
		System.out.println("Korisnicko ime: " + korisnickoIme);
		URI uri = uriBuilder.path("/api/user/" + korisnickoIme).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
}
