package application;


import java.util.Vector;
import java.util.Collections;


public class Statistics {
	private static Vector<Integer> v = new Vector<Integer>();
	private static Vector<Statistiche> statistiche = new Vector<Statistiche>();

		
public static Vector<Integer> getVett(String field){
	Vector<Tumore> g = Serialization.data();
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
		
public static int somma (String field) {
	Vector<Integer> vett = Statistics.getVett(field);
    int sum=0;
    for (Integer item : vett) {
	 sum += item ;
}
return sum;
}
	
public static float avg (String field) {
	Vector<Integer> vett = Statistics.getVett(field);
	int dim= vett.size();
	int sum= somma(field);
	float average = (float) sum / dim;
	return average;
}
	
public static Object max (String field) {
	Vector<Integer> vett = Statistics.getVett(field);
	Object obj = Collections.max(vett);
	return obj;
	}

public static Object min (String field) {
	Vector<Integer> vett = Statistics.getVett(field);
	Object obj = Collections.min(vett);
    return obj;
    }

public static double getVariance(String field) {
	Vector<Integer> vett = Statistics.getVett(field);
	int dim = vett.size();
	float avg = Statistics.avg(field);
    double temp = 0;
    for(float item :vett)
        temp += (item-avg)*(item-avg);
    return temp/(dim-1);
}

public static double getStdDev(String field) {
    return Math.sqrt(getVariance(field));
}

public static long getCount(String field) {
    Vector<Integer> vett = Statistics.getVett(field);
    long count = vett.stream().distinct().count();
    return count;
}

public static Vector<Statistiche> getStats(String field) {
	Statistiche v1 = new Statistiche(field , Statistics.avg(field), Statistics.min(field), Statistics.max(field), Statistics.getStdDev(field),Statistics.somma(field), Statistics.getCount(field))	; 	
	statistiche.add(v1);
	return statistiche;
}

}
