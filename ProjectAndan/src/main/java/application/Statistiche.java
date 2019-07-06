package application;

public class Statistiche {
    private String field;
	private float avg;
    private Object min;
    private Object max;
    public double devstd;
    private int sum;
    private long count;

	
	public Statistiche(String field, float avg, Object min, Object max, double devstd, int sum, long count ) {
		
		this.field = field ;
		this.avg = avg;
		this.min = min;
		this.max = max;
        this.devstd= devstd;
		this.sum = sum;
		this.count= count;
		
	}
	
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public double getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	public Object getMin() {
		return min;
	}
	public void setMin(Object min) {
		this.min = min;
	}
	public Object getMax() {
		return max;
	}
	public void setMax(Object max) {
		this.max = max;
	}

	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public double getDevstd() {
		return devstd;
	}
	public void setDevstd(double devstd) {
		this.devstd = devstd;
	}
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

}