package application;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class FilterUtils {
	public static boolean check(Object value, String operator, Object th) {
		if (th instanceof Number && value instanceof Number) {	
			Double thC = ((Number)th).doubleValue();
			Double valuec = ((Number)value).doubleValue();
			if (operator.equals("=="))
				return value.equals(th);
			else if (operator.equals(">"))
				return valuec > thC;
			else if (operator.equals("<"))
				return valuec < thC;
		}else if(th instanceof String && value instanceof String)
			return value.equals(th);
		return false;		
	}
	
	public static Vector<Integer> select(String fieldName, String operator, Object value) {
		Vector<Integer> src= StatisticsInt.getVett(fieldName, "0", 0);
		Vector<Integer> out = new Vector<Integer>();
		for(Integer item:src) {
			try {
				if(FilterUtils.check(item, operator, value))
					out.add(item);
			
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			//return out;
	}
		return out;
	}
	public static Vector<String> selectString(String fieldName, String operator, Object value) {
		Vector<String> src= StatisticsString.getVett(fieldName, "0", "0");
		Vector<String> out = new Vector<String>();
		for(String item:src) {
			try {
				if(FilterUtils.check(item, operator, value))
					out.add(item);
			
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		}
			//return out;
	}
		return out;
	}
}
