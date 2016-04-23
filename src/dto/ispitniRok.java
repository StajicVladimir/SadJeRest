package dto;
import java.sql.Date;

public class IspitniRok {
	private int id;
	private String datumPocetka;
	private String datumZavrsetka;
	private String naziv;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * @return the datumPocetka
	 */
	public String getDatumPocetka() {
		return datumPocetka;
	}
	/**
	 * @param datumPocetka the datumPocetka to set
	 */
	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
		
	}
	
	/**
	 * @return the datumZavrsetka
	 */
	public String getDatumZavrsetka() {
		return datumZavrsetka;
	}
	/**
	 * @param datumZavrsetka the datumZavrsetka to set
	 */
	public void setDatumZavrsetka(String datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
		
	}
	
	/**
	 * @return the naziv
	 */
	public String getNaziv() {
		return naziv;
	}
	/**
	 * @param naziv the naziv to set
	 */
	public void setNaziv(String naziv) {
		this.naziv = naziv;
		
	}
	
	
}
