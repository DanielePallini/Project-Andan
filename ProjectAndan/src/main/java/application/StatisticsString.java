package application;

import java.util.Vector;
import java.util.Collections;
public class StatisticsString {
	private static Vector<String> v = new Vector<String>();
	private static Vector<StatisticheString> statistiche = new Vector<StatisticheString>();
	
	public static Vector<String> getVett(String field){
		Vector<Tumore> g = Serialization.data();
		switch (field) {
		
		case  "periodo" : {Vector<String> v = new Vector<String>();
		for (Tumore item : g ) {
			v.add(item.getPeriodo()); 
			}
		return v;
		} 
		case "territorio" : {Vector<String> v = new Vector<String>();
		for (Tumore item : g ) {
			v.add(item.getTerritorio()); 
			}
		return v;
		} 
		case "patologia" : {Vector<String> v = new Vector<String>();
		for (Tumore item : g ) {
			v.add(item.getPatologia()); 
			}
		return v;
		} 
	   }
		return v;
	}
	public static Vector<StatisticheString> getStats(String field) {
		StatisticheString v1 = new StatisticheString(field , getCount(field))	; 	
		statistiche.add(v1);
		return statistiche;
	}
	public static long getCount() {
		

	}
}
