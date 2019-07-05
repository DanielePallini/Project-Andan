package application;


import java.util.Vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class StatisticsInt  {
	private static Vector<Integer> v = new Vector<Integer>();
	private static Vector<Statistiche> statistiche = new Vector<Statistiche>();

		
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
	
     

		
public static int somma (Vector<Integer> v) {
	// Vector<Integer> vett = getVett(field);
    int sum=0;
    for (Integer item : v) {
	 sum += item ;
}
return sum;
}
	
public static float avg (Vector<Integer> v) {
	//Vector<Integer> vett = getVett(field);
	int dim= v.size();
	int sum= somma(v);
	float average = (float) sum / dim;
	return average;
}
	
public static Object max (Vector<Integer> v) {
	//Vector<Integer> vett = getVett(field);
	Object obj = Collections.max(v);
	return obj;
	}

public static Object min (Vector<Integer> v) {
	//Vector<Integer> vett = getVett(field);
	Object obj = Collections.min(v);
    return obj;
    }

public static double getVariance(Vector<Integer> v) {
	// Vector<Integer> vett = getVett(field);
	int dim = v.size();
	float avg = StatisticsInt.avg(v);
    double temp = 0;
    for(float item :v)
        temp += (item-avg)*(item-avg);
    return temp/(dim-1);
}

public static double getStdDev(Vector<Integer> v) {
    return Math.sqrt(getVariance(v));
}

public static long getCount(Vector<Integer> v) {
    // Vector<Integer> vett = getVett(field);
    long count = v.stream().distinct().count();
    return count;
} 

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
