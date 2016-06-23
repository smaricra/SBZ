package sbz.projekat.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Racun {

	public enum StanjeRacuna {
		PORUCENO, OTKAZANO, REALIZOVANO
	};

	@Id
	private int sifra;
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public User getKupac() {
		return kupac;
	}
	public void setKupac(User kupac) {
		this.kupac = kupac;
	}
	public StanjeRacuna getStanje() {
		return stanje;
	}
	public void setStanje(StanjeRacuna stanje) {
		this.stanje = stanje;
	}
	public float getOriginalnaCena() {
		return originalnaCena;
	}
	public void setOriginalnaCena(float originalnaCena) {
		this.originalnaCena = originalnaCena;
	}
	public float getProcenatUmanjenja() {
		return procenatUmanjenja;
	}
	public void setProcenatUmanjenja(float procenatUmanjenja) {
		this.procenatUmanjenja = procenatUmanjenja;
	}
	public float getKonacnaCena() {
		return konacnaCena;
	}
	public void setKonacnaCena(float konacnaCena) {
		this.konacnaCena = konacnaCena;
	}
	public int getBrojPotrosenihBodova() {
		return brojPotrosenihBodova;
	}
	public void setBrojPotrosenihBodova(int brojPotrosenihBodova) {
		this.brojPotrosenihBodova = brojPotrosenihBodova;
	}
	public int getBrojOstvarenihBodova() {
		return brojOstvarenihBodova;
	}
	public void setBrojOstvarenihBodova(int brojOstvarenihBodova) {
		this.brojOstvarenihBodova = brojOstvarenihBodova;
	}
	public List<AkcijskiDogadjaj> getListaPopusta() {
		return listaPopusta;
	}
	public void setListaPopusta(List<AkcijskiDogadjaj> listaPopusta) {
		this.listaPopusta = listaPopusta;
	}
	public List<StavkaRacuna> getListaStavki() {
		return listaStavki;
	}
	public void setListaStavki(List<StavkaRacuna> listaStavki) {
		this.listaStavki = listaStavki;
	}
	public int getSifra() {
		return sifra;
	}
	private Date datum;
	@DBRef
	private User kupac;
	private StanjeRacuna stanje;
	private float originalnaCena;
	private float procenatUmanjenja;
	private float konacnaCena;
	private int brojPotrosenihBodova;
	private int brojOstvarenihBodova;
	@DBRef
	private List<AkcijskiDogadjaj> listaPopusta;
	@DBRef
	private List<StavkaRacuna> listaStavki;

}
