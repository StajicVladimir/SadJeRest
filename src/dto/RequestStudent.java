package dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestStudent {
   public int id;
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
	 * @return the ime
	 */
	public String getIme() {
		return ime;
	}
	/**
	 * @param ime the ime to set
	 */
	public void setIme(String ime) {
		this.ime = ime;
	}
	/**
	 * @return the prezime
	 */
	public String getPrezime() {
		return prezime;
	}
	/**
	 * @param prezime the prezime to set
	 */
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	/**
	 * @return the adresa
	 */
	public String getAdresa() {
		return adresa;
	}
	/**
	 * @param adresa the adresa to set
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	/**
	 * @return the kredit
	 */
	public int getKredit() {
		return kredit;
	}
	/**
	 * @param kredit the kredit to set
	 */
	public void setKredit(int kredit) {
		this.kredit = kredit;
	}
	/**
	 * @return the lozinka
	 */
	public String getLozinka() {
		return lozinka;
	}
	/**
	 * @param lozinka the lozinka to set
	 */
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	 public String ime;
     public String prezime;
     public String adresa;
     public int kredit;
     public String lozinka;
}
