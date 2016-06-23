package sbz.projekat.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class User {
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String korisnickoIme, String ime, String prezime, String sifra,
			Uloga uloga, Date datumRegistracije, UserAccount userAccount) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.ime = ime;
		this.prezime = prezime;
		this.sifra = sifra;
		this.uloga = uloga;
		this.datumRegistracije = datumRegistracije;
		this.userAccount = userAccount;
	}

	public enum Uloga { KUPAC, MENADZER, PRODAVAC };

	
	@Id
	private String korisnickoIme;
	private String ime;
	private String prezime;
	private String sifra;
	private Uloga uloga;
	private Date datumRegistracije;
    @DBRef
	private UserAccount userAccount;
	
	public Date getDatumRegistracije() {
		return datumRegistracije;
	}

	public void setDatumRegistracije(Date datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public Uloga getUloga() {
		return uloga;
	}
	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	
	
	

}
