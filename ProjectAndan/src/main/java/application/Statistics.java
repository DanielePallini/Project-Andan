package application;

import java.util.Collections;
import java.util.Vector;


public class Statistics {
	private static Vector<Integer> maschi = new Vector<Integer>();
	

		static {
	// Initizialize data
	Vector<Tumore> g = Serialization.data();
	Vector<Integer> maschi = new Vector<Integer>();
		for (Tumore item : g ) {
			maschi.add(item.getMaschi()); 
			}
		
		} 

public static int somma () {
	int sum=0;
for (Integer item : maschi) {
	 sum += item ;
}
return sum;
}
	
public static float avg () {
	int dim = 3332;
	int sum= somma();
	float average = sum / dim;
	return average;
}
	
public static Object max () {
	Object obj = Collections.max(maschi);
	return obj;
	}

public static Object min () {
    Object obj = Collections.min(maschi);
    return obj;
    }

}
