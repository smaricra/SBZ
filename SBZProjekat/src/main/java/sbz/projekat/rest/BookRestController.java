package sbz.projekat.rest;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import sbz.projekat.entity.Book;
import sbz.projekat.service.BookService;
// /api/v1/book/1

@Controller
@RequestMapping(value="/api/v1/book")
public class BookRestController {
	Logger logger = LoggerFactory.getLogger(BookRestController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody Book book, UriComponentsBuilder uriBuilder){
		logger.debug("enter");
		logger.debug(book.getName());
		bookService.saveBook(book);
		String id = book.getId();
		System.out.println("ZE ID is:" + id);
		URI uri = uriBuilder.path("/api/v1/book/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id)
	{
		Book book = bookService.getBook(id);
		if (book == null) {
			logger.warn("book with id {} not found", id);
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(book, HttpStatus.OK);
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> get()
	{ 
		List<Book> books = bookService.getAll();
		if (books == null) {
		
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(books, HttpStatus.OK);
	}
	
	@RequestMapping(value="/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> testMethod()
	{ 
		// DO FUN STUFF HERE
		
		
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value="/removeAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> removeAll()
	{ 
		List<Book> books = bookService.getAll();
		if (books == null) {
		
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		while (books.size()>0)
		{
			int index = books.size() - 1;
			bookService.removeBook(books.get(index));
			books.remove(index);
			System.out.println("OSTALO JOS: "+books.size());
		}
		return new ResponseEntity(books, HttpStatus.OK);
	
	}
	
	
}
