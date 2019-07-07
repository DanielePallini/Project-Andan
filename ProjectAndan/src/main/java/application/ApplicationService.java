package application;

import java.util.HashMap;
import java.util.Vector;
import org.springframework.stereotype.Component;

import data.JSON;
import data.Metadata;
import data.Serialization;
import data.Tumore;
import filter.FilterUtils;
import stats.StatisticsInt;
import stats.StatisticsString;
/**
 * Service di Application. 
 * @author Andrea Giuliani Daniele Pallini
 *
 */
@Component
public class ApplicationService {

	private static Vector<Tumore> tumori = new Vector<Tumore>();
	private static Vector<Metadata> metadati = new Vector<Metadata>();
	private static Object obj = new Object();
	
    static {
    	JSON.Json(); 	
	}

/**
 * Ritorna il vettore richiesto con una get /data
 * @return il vettore con tutti i record del csv di partenza
 */
	public static Vector<Tumore> getList() {
		//Serialization.parser();
		tumori = Serialization.data();
	    	return tumori;
	}
	/**
	 * Ritorna i metadati richiesti con get /metadata
	 * @return i metadati
	 */
	public static Vector<Metadata> getMeta() {
		Metadata m1 = new Metadata("periodo", "PERIODO", "String");
		Metadata m2 = new Metadata("territorio", "TERRITORIO", "String");
		Metadata m3 = new Metadata("patologia", "PATOLOGIA", "String");
		Metadata m4 = new Metadata("maschi", "MASCHI", "Integer");
		Metadata m5 = new Metadata("femmine", "FEMMINE", "Integer");

		metadati.add(m1);
		metadati.add(m2);
		metadati.add(m3);
		metadati.add(m4);
		metadati.add(m5);
	    	return metadati;
	}
	/**
	 * Ottiene le statistiche del campo richiesto tramite get stats/{field}
	 * @param field campo richiesto
	 * @param operator operatore di confronto richiesto
	 * @param value il valore da confrontare
	 * @return il vettore filtrato o errore se il campo richiesto non esiste
	 */
	public static Object getStat(String field, String operator, Object value) {
	   	 switch (field) {
      	 case "maschi" :	{Object obj = new Object () ;
      		                 obj = StatisticsInt.getStats(field,operator,value);
      	  		                        return obj;
      	  		                        }
      	 case "femmine" : {Object obj = new Object () ;
           obj = StatisticsInt.getStats(field,operator,value);
               return obj;
               }
      	 
      	 case "periodo" : {Object obj = new Object () ;
      		 
      		 obj=StatisticsString.countOccurrence(field,operator,value);
      		 return obj;}
      	 case "patologia" : {Object obj = new Object () ;
  		 
  		 obj=StatisticsString.countOccurrence(field,operator,value);
  		 return obj;}
      	 case "territorio" : {Object obj = new Object () ;
  		 
  		 obj=StatisticsString.countOccurrence(field,operator,value);
  		 return obj;}
      	 default: obj=new HashMap(){{ put("type", "Campo inesistente"); put("result", "ERRORE");}};
     }
	
        return obj;
        }
	
	/**
	 * Restituisce il vettore filtrato con i parametri in ingresso(metodo interno)
	 * @param field campo richiesto
	 * @param operator operatore di confronto richiesto
	 * @param value il valore da confrontare
	 * @return il vettore filtrato
	 */
	public static Vector<Tumore> dataFiltered(String field , String operator , Object value) {
		
		tumori = FilterUtils.selectData(field, operator, value) ;
	    	return tumori;
	}
	  /**
	   *  Ritorna il vettore richiesto con get /data/{field1}/{value1}/{field2}/{value2}
	   * @param field1 il primo campo richiesto
	   * @param value1 valore del primo campo
	   * @param field2 il secondo campo richiesto
	   * @param value2 valore del secondo campo
	   * @return il vettore con gli oggetti che rispettano entrambi i filtri(AND)
	   */
	public static Object and(String field1,String value1,String field2,String value2) {
		if ((field1.equals ("maschi") || field1.equals ("femmine") || field1.equals ("periodo") || field1.equals ("territorio") || field1.equals ("patologia")) && 
                (field2.equals ("maschi") || field2.equals ("femmine") || field2.equals ("periodo") || field2.equals ("territorio") || field2.equals ("patologia") )){
		int result1 = 0;
	       int result2 = 0;
	       Object valore1;
	       Object valore2;

		if (field1.equals ("maschi") || field1.equals("femmine")) {
			 result1= Integer.parseInt(value1);}
		if (field2.equals ("maschi") || field2.equals("femmine")) { 
			 result2= Integer.parseInt(value2); }

			 if(result1 == 0){
				 if (field1.equals ("maschi") || field1.equals("femmine")){valore1=result1;}
				 else { valore1 = value1;}
			 }

			 else {valore1=result1;}

			 if(result2 == 0){
				 if (field2.equals ("maschi") || field2.equals("femmine")){valore2=result2;}
				 else { valore2 = value2;}
			 }
			 else {valore2=result2; }
		tumori = FilterUtils.andData(field1, valore1, field2, valore2);
		return tumori;
		}
		  else {obj=new HashMap(){{ put("type", "Campo inesistente"); put("result", "ERRORE");}};
	        return obj;
	         }
		
	}
	/**
	 * Ottiene i record del csv di partenza con il filtro voluto tramite /data/{field}/{operator}/{value}
	 * @param field campo richiesto
	 * @param operator operatore di confronto richiesto
	 * @param value il valore da confrontare
	 * @return il vettore filtrato o errore se il campo richiesto non esiste
	 */
	 public static Object filtriData(String field,String operator,String value) {
		 if (field.equals("maschi") || field.equals("femmine")) {
			 int result= Integer.parseInt(value);
			 return dataFiltered(field,operator,result);
		}else if (field.equals("patologia") || field.equals("territorio") || field.equals("periodo")) {
			return dataFiltered(field,operator,value);}
		else {obj=new HashMap(){{ put("type", "Campo inesistente"); put("result", "ERRORE");}};
		return obj;}
	 }
	 /**
		 * Ottiene le statistiche del campo richiesto con il filtro voluto tramite /stats/{field}/{operator}/{value}
		 * @param field campo richiesto
		 * @param operator operatore di confronto richiesto
		 * @param value il valore da confrontare
		 * @return il vettore filtrato o errore se il campo richiesto non esiste
		 */
	 public static Object filtri(String field,String operator, String value ) {
		 if (field.equals("maschi") || field.equals("femmine")) {
			 int result= Integer.parseInt(value);
			 return ApplicationService.getStat(field,operator,result);
		}else if (field.equals("patologia") || field.equals("territorio") || field.equals("periodo")) {
			return ApplicationService.getStat(field,operator,value);}
		else {obj=new HashMap(){{ put("type", "Campo inesistente"); put("result", "ERRORE");}};
		return obj;}
	 }
}