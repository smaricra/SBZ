package sbz.projekat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class KategorijaKupca {

	@Id
	private int sifra;
	private String naziv;
	//private PragPotrosnje
	
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getSifra() {
		return sifra;
	}
	
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
}
