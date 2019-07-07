package stats;
/**
 * Classe delle Statistiche per i campi di tipo int
 * @author Andrea Giuliani Daniele Pallini
 *
 */
public class Statistiche {
    private String field;
	private float avg;
    private Object min;
    private Object max;
    public double devstd;
    private int sum;
    private long count;
/**
 * Costruttore di Statistiche
 * @param field il campo richiesto
 * @param avg media
 * @param min minimo
 * @param max massimo
 * @param devstd deviazione standard
 * @param sum somma
 * @param count conteggio elementi unici
 */
	
	public Statistiche(String field, float avg, Object min, Object max, double devstd, int sum, long count ) {
		
		this.field = field ;
		this.avg = avg;
		this.min = min;
		this.max = max;
        this.devstd= devstd;
		this.sum = sum;
		this.count= count;
		
	}
	/**
	 * Restituisce il conteggio degli elementi unici del vettore
	 * @return il conteggio degli elementi unici del vettore
	 */
	public long getCount() {
		return count;
	}
	/**
	 * Imposta il nuovo conteggio di Statistiche
	 * @param count il nuovo conteggio
	 */
	public void setCount(long count) {
		this.count = count;
	}
	/**
	 * Restituisce la media degli elementi del vettore
	 * @return la media degli elementi del vettore
	 */
	public double getAvg() {
		return avg;
	}
	/**
	 * Imposta la nuova media di Statistiche
	 * @param avg la nuova media
	 */
	public void setAvg(float avg) {
		this.avg = avg;
	}
	/**
	 * Restituisce il minimo tra gli elementi del vettore
	 * @return il minimo tra gli elementi del vettore
	 */
	public Object getMin() {
		return min;
	}
	/**
	 * Imposta il nuovo minimo di Statistiche
	 * @param min il nuovo minimo
	 */
	public void setMin(Object min) {
		this.min = min;
	}
	/**
	 * Restituisce il massimo tra gli elementi del vettore
	 * @return il massimo tra gli elementi del vettore
	 */
	public Object getMax() {
		return max;
	}
	/**
	 * Imposta il nuovo massimo di Statistiche
	 * @param max il nuovo massimo
	 */
	public void setMax(Object max) {
		this.max = max;
	}
	/**
	 * Restituisce la somma tra gli elementi del vettore
	 * @return la somma tra gli elementi del vettore
	 */
	public int getSum() {
		return sum;
	}
	/**
	 * Imposta la nuova somma di Statistiche
	 * @param sum la nuova somma
	 */
	public void setSum(int sum) {
		this.sum = sum;
	}
	/**
	 * Restituisce la deviazione standard degli elementi del vettore
	 * @return la deviazione standard degli elementi del vettore
	 */
	public double getDevstd() {
		return devstd;
	}
	/**
	 * Imposta la nuova deviazione standard di Statistiche
	 * @param devstd la nuova deviazione standard
	 */
	public void setDevstd(double devstd) {
		this.devstd = devstd;
	}
	/**
	 * Restituisce il campo del vettore
	 * @return il campo del vettore
	 */
	public String getField() {
		return field;
	}
	/**
	 * Imposta il nuovo campo di Statistiche
	 * @param field il nuovo campo
	 */
	public void setField(String field) {
		this.field = field;
	}

}