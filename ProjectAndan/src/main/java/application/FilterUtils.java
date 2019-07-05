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
	public static Vector<Tumore> selectData(String fieldName, String operator, Object value) {
		Vector<Tumore> src= Serialization.data();
		Vector<Tumore> out = new Vector<Tumore>();
		for(Tumore item:src) {
			try {
				Method m = item.getClass().getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);
				try {
					Object tmp = m.invoke(item);
					if(FilterUtils.check(tmp, operator, value))
						out.add(item);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
		return out;
	}
}
