package data;
/** 
 * Classe che da' informazioni sul tumore
 * 
 * @author Andrea Giuliani Daniele Pallini
 *
 */


public class Tumore	{ 
    private String periodo;
    private String territorio;
    private String patologia;
    private int maschi;
    private int femmine;
	public Tumore() {
		
	}
	/**
	 * Costruttore di un Tumore
	 *   
	 * @param periodo Periodo del Tumore
	 * @param territorio Territorio del Tumore
	 * @param patologia Patologia del Tumore
	 * @param maschi Numero maschi con Tumore
	 * @param femmine Numore femmine con Tumore
	 */
	public Tumore(String periodo, String territorio, String patologia, int maschi, int femmine) {
	
		this.periodo = periodo;
		this.territorio = territorio;
		this.patologia = patologia;
		this.maschi= maschi;
		this.femmine = femmine;
	}
	/**
	 * Restituisce il periodo di un Tumore 
	 * @return il periodo del Tumore
	 */
	
	public String getPeriodo() {
		return periodo;
	}
	/**
	 * Imposta il nuovo periodo del Tumore
	 * @param periodo il nuovo periodo
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	/**
	 * Restituisce il territorio di un Tumore 
	 * @return il territorio del Tumore
	 */
	public String getTerritorio() {
		return territorio;
	}
	/**
	 * Imposta il nuovo territorio del Tumore
	 * @param territorio il nuovo territorio
	 */
	public void setTerritorio(String territorio) {
		this.territorio = territorio;
	}
	/**
	 * Restituisce la patologia di un Tumore 
	 * @return la patologia del Tumore
	 */
	public String getPatologia() {
		return patologia;
	}
	/**
	 * Imposta la nuova patologia del Tumore
	 * @param patologia la nuova patologia
	 */
	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}
	/**
	 * Restituisce il numero di maschi con Tumore 
	 * @return il numero di maschi con Tumore
	 */
	public int getMaschi() {
		return maschi;
	}
	/**
	 * Imposta il nuovo numero di maschi con Tumore
	 * @param maschi il nuovo numero di maschi
	 */
	public void setMaschi(int maschi) {
		this.maschi = maschi;
	}
	/**
	 * Restituisce il numero di femmine con un Tumore 
	 * @return il numero di femmine con un Tumore
	 */
	public int getFemmine() {
		return femmine;
	}
	/**
	 * Imposta il nuovo numero di femmine con Tumore
	 * @param femmine il nuovo numero di femmine
	 */
	public void setFemmine(int femmine) {
		this.femmine = femmine;
	}
	
}

