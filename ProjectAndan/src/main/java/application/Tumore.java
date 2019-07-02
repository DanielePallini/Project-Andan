package application;

import java.io.Serializable;

public class Tumore implements Serializable {
    private String periodo;
    private String territorio;
    private String patologia;
    private int maschi;
    private int femmine;
	public Tumore() {
		// TODO Auto-generated constructor stub
	}
	public Tumore(String periodo, String territorio, String patologia, int maschi, int femmine) {
		// TODO Auto-generated constructor stub
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
	public int getMaschi() {
		return maschi;
	}
	public void setMaschi(int maschi) {
		this.maschi = maschi;
	}
	public int getFemmine() {
		return femmine;
	}
	public void setFemmine(int femmine) {
		this.femmine = femmine;
	}
	@Override
	public String toString() {
		return "[Periodo=" + periodo + ", Territorio=" + territorio + ",Patologia=" + patologia + ", Maschi=" + maschi + ", Femmine=" + femmine + "]\n";
	}
}

