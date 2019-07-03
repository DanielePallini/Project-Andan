8package application;

import java.io.Serializable;

public class Statistiche implements Serializable {
    private float avg;
    private Object min;
    private Object max;
    //private float devstd;
    private int sum;
 //   private int count;
	public Statistiche() {
		}
	public Statistiche(float avg, Object min, Object max, int sum) {
		
		this.avg = avg;
		this.min = min;
		this.max = max;
	//	this.devstd= devstd;
		this.sum = sum;
	//	this.count = count;
	}
	
	
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	public Object getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public Object getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
/*	public float getDevstd() {
		return devstd;
	}
	//public void setDevstd(float devstd) {
		this.devstd = devstd;
	}*/
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
/*	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}*/
	 }
