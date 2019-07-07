package stats;


import java.util.Vector;

import data.Serialization;
import data.Tumore;
import filter.FilterUtils;

import java.util.Collections;

/**
 * Classe che gestisce le statistiche per i campi di tipo int
 * @author Andrea Giuliani Daniele Pallini
 *
 */
public class StatisticsInt  {
	private static Vector<Integer> v = new Vector<Integer>();
	private static Vector<Statistiche> statistiche = new Vector<Statistiche>();
	/**Restituisce il vettore con le statistiche dei campi di tipo String
	 * 
	 * @param field il campo richiesto
	 * @param operator operatore di confronto richiesto
	 * @param value la stringa da confrontare
	 * @return il vettore con le statistiche del campo richiesto
	 */
		
public static Vector<Integer> getVett(String field, String operator, Object value){
	
	Vector<Tumore> g = Serialization.data();
	if (operator != "0") {
		Vector<Integer> v = filterField(field,operator,value);
		return v;
	}
	switch (field) {
	
	case  "maschi" : {Vector<Integer> v = new Vector<Integer>();
	for (Tumore item : g ) {
		v.add(item.getMaschi()); 
		}
	return v;
	} 
	case "femmine" : {Vector<Integer> v = new Vector<Integer>();
	for (Tumore item : g ) {
		v.add(item.getFemmine()); 
		} 
	return v; 
	} 
   }
	
	return v;
	}
	
     
/**
 * Somma gli item del vettore
 * @param v vettore in ingresso
 * @return la somma degli elementi del vettore
 */
		
public static int somma (Vector<Integer> v) {
	// Vector<Integer> vett = getVett(field);
    int sum=0;
    for (Integer item : v) {
	 sum += item ;
}
return sum;
}
/**Calcola la media degli elementi del vettore
 * 	
 * @param v vettore in ingresso
 * @return la media degli elementi del vettore
 */
public static float avg (Vector<Integer> v) {
	//Vector<Integer> vett = getVett(field);
	int dim= v.size();
	int sum= somma(v);
	float average = (float) sum / dim;
	return average;
}
/**Trova il massimo tra gli elementi del vettore
 * 	
 * @param v vettore in ingresso
 * @return il massimo tra gli elementi del vettore
 */	
public static Object max (Vector<Integer> v) {
	//Vector<Integer> vett = getVett(field);
	Object obj = Collections.max(v);
	return obj;
	}
/**Trova il minimo tra gli elementi del vettore
 * 	
 * @param v vettore in ingresso
 * @return il minimo tra gli elementi del vettore
 */	
public static Object min (Vector<Integer> v) {
	//Vector<Integer> vett = getVett(field);
	Object obj = Collections.min(v);
    return obj;
    }
/**Calcola la varianza degli elementi del vettore
 * 	
 * @param v vettore in ingresso
 * @return la varianza degli elementi del vettore
 */
public static double getVariance(Vector<Integer> v) {
	// Vector<Integer> vett = getVett(field);
	int dim = v.size();
	float avg = StatisticsInt.avg(v);
    double temp = 0;
    for(float item :v)
        temp += (item-avg)*(item-avg);
    return temp/(dim-1);
}
/**Calcola la deviazione standard degli elementi del vettore
 * 	
 * @param v vettore in ingresso
 * @return la deviazione standard degli elementi del vettore
 */
public static double getStdDev(Vector<Integer> v) {
    return Math.sqrt(getVariance(v));
}
/**Conta gli elementi unici del vettore
 * 	
 * @param v vettore in ingresso
 * @return il numero degli elementi unici del vettore
 */
public static long getCount(Vector<Integer> v) {
    // Vector<Integer> vett = getVett(field);
    long count = v.stream().distinct().count();
    return count;
} 
/**Calcola le statistiche del campo richiesto in base al filtro
 * 
 * @param field il campo richiesto
 * @param operator operatore di confronto richiesto
 * @param value il valore da confontare
 * @return il vettore con le statistiche del campo richiesto
 */
public static Vector<Statistiche> getStats(String field,String operator, Object value) {
	Vector<Integer> v = getVett(field,operator,value);
	Statistiche v1 = new Statistiche(field , avg(v), min(v), max(v), getStdDev(v),somma(v), getCount(v)); 	
	statistiche.add(v1);
	return statistiche;
}
public static Vector<Integer> filterField(String field, String operator, Object value) {
	
	return FilterUtils.select(field, operator, value);
}

}
