package stats;

import java.util.Vector;

import data.Serialization;
import data.Tumore;
import filter.FilterUtils;

import java.util.HashMap;
import java.util.Map;
/**
 * Classe che gestisce  le statistiche per i campi di tipo String
 * @author Andrea Giuliani Daniele Pallini
 *
 */
public class StatisticsString {
	private static Vector<String> v = new Vector<String>();
	// private static Vector<StatisticheString> statistiche = new Vector<StatisticheString>();
	/**Restituisce il vettore con le statistiche dei campi di tipo String
	 * 
	 * @param field il campo richiesto
	 * @param operator operatore di confronto richiesto
	 * @param value la stringa da confrontare
	 * @return il vettore con le statistiche del campo richiesto
	 */
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
	/**Conta il numero di volte che la stringa richiesta è presente
	 * 
	 * @param field campo richiesto
	 * @param operator operatore di confronto richiesto
	 * @param value la stringa da confrontare
	 * @return hm hash map contenente il numero di volte che la stringa richiesta è presente
	 * 
	 */
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