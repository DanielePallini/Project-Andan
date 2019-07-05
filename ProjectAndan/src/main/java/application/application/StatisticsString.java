package application;

import java.util.Vector;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatisticsString {
	private static Vector<String> v = new Vector<String>();
	// private static Vector<StatisticheString> statistiche = new Vector<StatisticheString>();
	
	public static Vector<String> getVett(String field, String operator, Object value){
		Vector<Tumore> g = Serialization.data();
		if (operator != "0") {
			Vector<String> v = filterField(field,operator,value);
			return v;
		}
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
	
public static Map<String, Integer> countOccurrence(String field, String operator, Object value) {
		Vector<String> vett = getVett(field,operator,value);
		Map<String,Integer> hm = new HashMap();

    for(String item: vett){

        if(!hm.containsKey(item)){
            hm.put(item,1);
        }else{
            hm.put(item, hm.get(item)+1);
        }
    }
   return hm;
	}
public static Vector<String> filterField(String field, String operator, Object value) {
	
	return FilterUtils.selectString(field, operator, value);
}
}