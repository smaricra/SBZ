package sbz.projekat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserAccount {
	
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private int id;
	private String adresaIsporuke;
	private int nagradniBodovi;
	private KategorijaKupca kategorija;
	//dodati jos istoriju kupovina	
	
	public String getAdresaIsporuke() {
		return adresaIsporuke;
	}
	public void setAdresaIsporuke(String adresaIsporuke) {
		this.adresaIsporuke = adresaIsporuke;
	}
	public int getNagradniBodovi() {
		return nagradniBodovi;
	}
	public void setNagradniBodovi(int nagradniBodovi) {
		this.nagradniBodovi = nagradniBodovi;
	}
	public KategorijaKupca getKategorija() {
		return kategorija;
	}
	public void setKategorija(KategorijaKupca kategorija) {
		this.kategorija = kategorija;
	}
	
}
