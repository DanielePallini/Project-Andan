import java.io.Serializable;

public class Tumore implements Serializable {
    private String periodo;
    private String territorio;
    private String patologia;
    private String maschi;
    private String femmine;
	public Tumore() {
		
	}
	public Tumore(String periodo, String territorio, String patologia, String maschi, String femmine) {
	
		this.periodo = periodo;
		this.territorio = territorio;
		this.patologia = patologia;
		this.maschi= maschi;
		this.femmine = femmine;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getTerritorio() {
		return territorio;
	}
	public void setTerritorio(String territorio) {
		this.territorio = territorio;
	}
	public String getPatologia() {
		return patologia;
	}
	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}
	public String getMaschi() {
		return maschi;
	}
	public void setMaschi(String maschi) {
		this.maschi = maschi;
	}
	public String getFemmine() {
		return femmine;
	}
	public void setFemmine(String femmine) {
		this.femmine = femmine;
	}
	@Override
	public String toString() {
		return "[Periodo=" + periodo + ", Territorio=" + territorio + ",Patologia=" + patologia + ", Maschi=" + maschi + ", Femmine=" + femmine + "]/n";
	}
}
