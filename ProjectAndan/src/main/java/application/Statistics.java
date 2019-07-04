package application;

import java.util.Collections;
import java.util.Vector;


public class Statistics {
	private static Vector<Integer> maschi = new Vector<Integer>();
	private static Vector<Statistiche> statistiche = new Vector<Statistiche>();

		
public static Vector<Integer> getMaschi(){
Vector<Tumore> g = Serialization.data();
Vector<Integer> maschi = new Vector<Integer>();
	for (Tumore item : g ) {
		maschi.add(item.getMaschi()); 
		}
	return maschi;
}
		
public static int somma () {
	Vector<Integer> maschio = Statistics.getMaschi();
    int sum=0;
    for (Integer item : maschio) {
	 sum += item ;
}
return sum;
}
	
public static float avg () {
	Vector<Integer> maschio = Statistics.getMaschi();
	int dim= maschio.size();
	int sum= somma();
	float average = sum / dim;
	return average;
}
	
public static Object max () {
	Vector<Integer> maschio = Statistics.getMaschi();
	Object obj = Collections.max(maschio);
	return obj;
	}

public static Object min () {
	Vector<Integer> maschio = Statistics.getMaschi();
	Object obj = Collections.min(maschio);
    return obj;
    }

public static double getVariance() {
	Vector<Integer> maschio = Statistics.getMaschi();
	int dim = maschio.size();
	float avg = Statistics.avg();
    double temp = 0;
    for(float item :maschio)
        temp += (item-avg)*(item-avg);
    return temp/(dim-1);
}

public static double getStdDev() {
    return Math.sqrt(getVariance());
}

public static Vector<Statistiche> StatsMaschi() {
	Statistiche v1 = new Statistiche("Maschi" , Statistics.avg(), Statistics.min(), Statistics.max(), Statistics.getStdDev(),Statistics.somma())	; 	
	statistiche.add(v1);
	return statistiche;
}

}
