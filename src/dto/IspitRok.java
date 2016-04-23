package dto;

public class IspitRok {
	String nazivPredmeta;
	String profesor;
	String datum;
	int polozio;
	
	/**
	 * @return the datum
	 */
	public String getDatum() {
		return datum;
	}
	/**
	 * @param datum the datum to set
	 */
	public void setDatum(String datum) {
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
