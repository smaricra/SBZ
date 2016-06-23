package sbz.projekat.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PopustNaRacun {

	public enum VrstaPopusta {OSNOVNI, DODATNI}
	@Id
	private int sifra;
	@DBRef
	private Racun racun;
	private float procenatUmanjenja;
	private VrstaPopusta vrstaPopusta;
	public Racun getRacun() {
		return racun;
	}
	public void setRacun(Racun racun) {
		this.racun = racun;
	}
	public float getProcenatUmanjenja() {
		return procenatUmanjenja;
	}
	public void setProcenatUmanjenja(float procenatUmanjenja) {
		this.procenatUmanjenja = procenatUmanjenja;
	}
	public VrstaPopusta getVrstaPopusta() {
		return vrstaPopusta;
	}
	public void setVrstaPopusta(VrstaPopusta vrstaPopusta) {
		this.vrstaPopusta = vrstaPopusta;
	}
	public int getSifra() {
		return sifra;
	}
	
	
}
