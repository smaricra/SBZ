package sbz.projekat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PragPotrosnje {
	
	@Id
	private int id;

	public int getId() {
		return id;
	}
	
}
