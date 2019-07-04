package application;
import java.io.Serializable;

public class StatisticheString implements Serializable {
	private String field;
	private long count;
	
	public StatisticheString(String field, long count) {
		this.field=field;
		this.count=count;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
}
