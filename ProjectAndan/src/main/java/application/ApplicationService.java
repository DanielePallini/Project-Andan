package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



import java.util.List;

import static java.lang.String.format;

@Component
public class ApplicationService {

	private static Vector<Tumore> tumori = new Vector<Tumore>();
	private static Vector<Metadata> metadati = new Vector<Metadata>();
	private static Object obj = new Object();
	
    static {
		//Initialize Data
    	
    	
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
	}


	public static Vector<Tumore> getList() {
		Serialization.parser();
		tumori = Serialization.data();
	    	return tumori;
	}
	public static Vector<Metadata> getMeta() {
	    	return metadati;
	}
	
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
	
	public static Vector<Tumore> dataFiltered(String field , String operator , Object value) {
		
		tumori = FilterUtils.selectData(field, operator, value) ;
	    	return tumori;
	}
	   
	public static Vector<Tumore> and(String field1,String value1,String field2,String value2) {
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
			 
			 else {valore1=value1;}
			 
			 if(result2 == 0){
				 if (field2.equals ("maschi") || field2.equals("femmine")){valore2=result2;}
				 else { valore2 = value2;}
			 }
			 else {valore2=result2;
			 }
		tumori = FilterUtils.andData(field1, valore1, field2, valore2);
		return tumori;
		
	}
	 public static Object filtriData(@PathVariable String field,@PathVariable String operator,@PathVariable String value) {
		 if (field.equals("maschi") || field.equals("femmine")) {
			 int result= Integer.parseInt(value);
			 return dataFiltered(field,operator,result);
		}else if (field.equals("patologia") || field.equals("territorio") || field.equals("periodo")) {
			return dataFiltered(field,operator,value);}
		else {obj=new HashMap(){{ put("type", "Campo inesistente"); put("result", "ERRORE");}};
		return obj;}
	 }
	 public static Object filtri(@PathVariable String field,@PathVariable String operator,@PathVariable String value ) {
		 if (field.equals("maschi") || field.equals("femmine")) {
			 int result= Integer.parseInt(value);
			 return ApplicationService.getStat(field,operator,result);
		}else if (field.equals("patologia") || field.equals("territorio") || field.equals("periodo")) {
			return ApplicationService.getStat(field,operator,value);}
		else {obj=new HashMap(){{ put("type", "Campo inesistente"); put("result", "ERRORE");}};
		return obj;}
	 }
}