package sbz.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sbz.projekat.entity.Book;
import sbz.projekat.repository.BookDao;


@Service("BookService")
@Transactional
public class BookService {
	
	@Autowired
	private BookDao bookDao;
	
	public void saveBook(Book book)
	{
		bookDao.save(book);
	}
	
	public Book getBook(String id) {
		return bookDao.findById(id);
	}
	
	public List<Book> getAll() {
		return bookDao.findAll();
		
	}
	
	public void findAndRemove(Query query) {
		bookDao.findAndRemove(query);		
	}
	
	public void removeBook(Book book) {
		bookDao.removeObject(book);
	}

}
