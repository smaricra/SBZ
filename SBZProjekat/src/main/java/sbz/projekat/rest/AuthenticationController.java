package sbz.projekat.rest;

import java.net.URI;

import javax.ws.rs.core.Response;

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

import sbz.projekat.entity.User;
import sbz.projekat.entity.UserAccount;
import sbz.projekat.entity.User.Uloga;
import sbz.projekat.service.UserService;

@Controller
@RequestMapping(value = "/api/authentication")
public class AuthenticationController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/logIn", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create(@RequestBody User user) throws Exception {
		String username = user.getKorisnickoIme();
		String password = user.getSifra();
		System.out.println(username);
		System.out.println(password);
		// Authenticate the user using the credentials provided
		User u = authenticate(username, password);
		Uloga uloga = u.getUloga();
		if (uloga != null) {

			// Issue a token for the user

			// Return the token on the response
			return new ResponseEntity(u, HttpStatus.OK);
		} else
			System.out.println("NEUSPELO");
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);

	}

	private User authenticate(String username, String password)
			throws Exception {
		// Authenticate against a database, LDAP, file or whatever
		// Throw an Exception if the credentials are invalid
		System.out.println(username);
		User u = userService.findByUsername(username);
		if (u.getSifra().equals(password)) {
			return u;
		} else {
			return null;
		}
	}

}
