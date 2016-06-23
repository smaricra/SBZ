package sbz.projekat.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StavkaRacuna {

	@Id
	private int id;
	//@Indexed(unique = true)
	private int redniBroj;
	@DBRef
	private Artikal artikal;
	private float jedinicnaCenaArtiklaNaDanKupovine;
	private int kolicina;
	private float originalnaUkupnaCenaStavke;
	private float procenatUmanjenja;
	private float konacnaCenaStavke;
	@DBRef
	private List<PopustNaStavku> listaPopusta;
	
	public int getRedniBroj() {
		return redniBroj;
	}
	public void setRedniBroj(int redniBroj) {
		this.redniBroj = redniBroj;
	}
	public Artikal getArtikal() {
		return artikal;
	}
	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}
	public float getJedinicnaCenaArtiklaNaDanKupovine() {
		return jedinicnaCenaArtiklaNaDanKupovine;
	}
	public void setJedinicnaCenaArtiklaNaDanKupovine(
			float jedinicnaCenaArtiklaNaDanKupovine) {
		this.jedinicnaCenaArtiklaNaDanKupovine = jedinicnaCenaArtiklaNaDanKupovine;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public float getOriginalnaUkupnaCenaStavke() {
		return originalnaUkupnaCenaStavke;
	}
	public void setOriginalnaUkupnaCenaStavke(float originalnaUkupnaCenaStavke) {
		this.originalnaUkupnaCenaStavke = originalnaUkupnaCenaStavke;
	}
	public float getProcenatUmanjenja() {
		return procenatUmanjenja;
	}
	public void setProcenatUmanjenja(float procenatUmanjenja) {
		this.procenatUmanjenja = procenatUmanjenja;
	}
	public float getKonacnaCenaStavke() {
		return konacnaCenaStavke;
	}
	public void setKonacnaCenaStavke(float konacnaCenaStavke) {
		this.konacnaCenaStavke = konacnaCenaStavke;
	}
	public List<PopustNaStavku> getListaPopusta() {
		return listaPopusta;
	}
	public void setListaPopusta(List<PopustNaStavku> listaPopusta) {
		this.listaPopusta = listaPopusta;
	}
	public int getId() {
		return id;
	}
	
	
}
