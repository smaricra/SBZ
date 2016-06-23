package sbz.projekat.repository;

import org.springframework.stereotype.Repository;

import sbz.projekat.entity.Book;


@Repository
public class BookDao extends MongodbBaseDao<Book>{

	@Override
	protected Class<Book> getEntityClass() {
		return Book.class;
	}
}
