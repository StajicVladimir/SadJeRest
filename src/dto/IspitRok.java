package dto;

import java.util.Date;

public class IspitRok {
	String nazivPredmeta;
	String profesor;
	Date datum;
	int polozio;
	
	/**
	 * @return the datum
	 */
	public Date getDatum() {
		return datum;
	}
	/**
	 * @param datum the datum to set
	 */
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	/**
	 * @return the profesor
	 */
	public String getProfesor() {
		return profesor;
	}
	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	/**
	 * @return the nazivPredmeta
	 */
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	/**
	 * @param nazivPredmeta the nazivPredmeta to set
	 */
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	
	/**
	 * @return the polozio
	 */
	public int getPolozio() {
		return polozio;
	}
	/**
	 * @param polozio the polozio to set
	 */
	public void setPolozio(int polozio) {
		this.polozio = polozio;
	}
}
