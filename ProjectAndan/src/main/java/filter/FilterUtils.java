package filter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Vector;

import data.Serialization;
import data.Tumore;
import stats.StatisticsInt;
import stats.StatisticsString;

/**
 * Classe che si occupa della gestione dei filtri sia di campi di tipo String che di Int
 * @author Andrea Giuliani Daniele Pallini
 *
 */

public class FilterUtils {
	/**
	 * Confronta il valore passato con gli oggetti di Tumore in base all'operatore e restituisce vero o falso 
	 * @param value item di Tumore
	 * @param operator operatore di confronto
	 * @param th il valore da confrontare
	 * @return il risultato(vero o falso) del confronto
	 */
	
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
	/**
	 * Confronto per l'operatore not
	 * @param value item di Tumore
	 * @param operator e' il not
	 * @param th il valore da confrontare
	 * @return il risultato(vero o falso) del confronto
	 */
	
	public static boolean checkNot(Object value, String operator, Object th) {
		if ((th instanceof Number && value instanceof Number) || (th instanceof String && value instanceof String)) {	
					return !(value.equals(th));}
				return false;		
				}
	/**
	 * Confronto per l'operatore and
	 * @param value item di Tumore
	 * @param th il valore da confrontare
	 * @return il risultato(vero o falso) del confronto
	 */
	public static boolean checkAnd(Object value, Object th) {
		if ((th instanceof Number && value instanceof Number) || (th instanceof String && value instanceof String)) {	
			return (value.equals(th));}
		return false;
	}
	/**Metodo per campi di tipo int. Aggiunge al vettore se il confronto con l'operatore restituisce vero(vettore filtrato)
	 * 
	 * @param fieldName il campo richiesto
	 * @param operator operatore richiesto
	 * @param value item di Tumore
	 * @return il vettore con il filtro richiesto
	 */
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
	/**Metodo per campi di tipo String. Aggiunge al vettore se il confronto con l'operatore restituisce vero(vettore filtrato)
	 * 
	 * @param fieldName il campo richiesto
	 * @param operator operatore richiesto
	 * @param value item di Tumore
	 * @return il vettore con il filtro richiesto
	 */
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
	/**Restituisce i record che rispettano il filtro sul campo richiesto
	 * 
	 *@param fieldName il campo richiesto
	 * @param operator operatore richiesto
	 * @param value item di Tumore
	 * @return il vettore contenente i record con il filtro richiesto
	 */
	public static Vector<Tumore> selectData(String fieldName, String operator, Object value) {
		Vector<Tumore> src= Serialization.data();
		Vector<Tumore> out = new Vector<Tumore>();
		if (operator.equals("not")) {
			for(Tumore item:src) {
			try {
				Method m = item.getClass().getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);
				try {
					Object tmp = m.invoke(item);
					if(FilterUtils.checkNot(tmp, operator, value))
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
	} else {
		
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
		return out;}
	}
	/**Gestisce il filtro con l'operatore AND
	 * 
	 * @param field1 nome del primo campo richiesto
	 * @param valore1 valore del primo campo
	 * @param field2 nome del secondo campo richiesto
	 * @param valore2 valore del secondo campo
	 * @return il vettore contenente i record che rispettano entrambi i filtri
	 */
	public static Vector<Tumore> andData(String field1, Object valore1, String field2, Object valore2) {
		Vector<Tumore> src= Serialization.data();
		Vector<Tumore> out = new Vector<Tumore>();
		 
			for(Tumore item:src) {
			try {
				Method m = item.getClass().getMethod("get"+field1.substring(0, 1).toUpperCase()+field1.substring(1),null);
				Method m1 = item.getClass().getMethod("get"+field2.substring(0, 1).toUpperCase()+field2.substring(1),null);
				try {
					Object tmp1 = m.invoke(item);
					Object tmp2 = m1.invoke(item);
					
					if(FilterUtils.checkAnd(tmp1,valore1) && FilterUtils.checkAnd(tmp2,valore2) )
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