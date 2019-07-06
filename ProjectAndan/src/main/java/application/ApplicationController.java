package application;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import com.google.gson.Gson;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
	
	private static Object objs = new Object();
	
	
	
	@GetMapping("/data")
    public Vector<Tumore> getAll() {
        return ApplicationService.getList();
	}
	@RequestMapping(value = "/data/{field}/{operator}/{value}" , method=RequestMethod.GET)
    public Object filtriData(@PathVariable String field,@PathVariable String operator,@PathVariable String value) {
       
		if (field.equals("maschi") || field.equals("femmine")) {
		 int result= Integer.parseInt(value);
		 return ApplicationService.dataFiltered(field,operator,result);
	}else if (field.equals("patologia") || field.equals("territorio") || field.equals("periodo")) {
		return ApplicationService.dataFiltered(field,operator,value);}
	else {objs=new HashMap(){{ put("type", "Campo inesistente"); put("result", "ERRORE");}};
	return objs;}
	
	}
		
	@RequestMapping(value = "/data/{field1}/{value1}/{field2}/{value2}" , method=RequestMethod.GET)
    public Object and(@PathVariable String field1,@PathVariable String value1,@PathVariable String field2 , @PathVariable String value2) {
       int result1 = 0;
       int result2 = 0;
       Object valore1;
       Object valore2;
     
	if (field1.equals ("maschi") || field1.equals("femmine")) {
		 result1= Integer.parseInt(value1);}
	if (field2.equals ("maschi") || field2.equals("femmine")) { 
		 result2= Integer.parseInt(value2); }
	
		 if(result1 == 0) 
		 { valore1 = value1;}
		 else {valore1=result1;}
		 
		 if(result2 == 0) 
		 {  valore2 = value2;
		 }
		 else {valore2=result2;
		 }
		 
		 return ApplicationService.and(field1, valore1, field2, valore2);
}
	@GetMapping("/metadata")
    public Vector<Metadata> getM() {
        return ApplicationService.getMeta();
	}
   
	@GetMapping("/stats")
    public Object stats(@RequestParam String field) {
           return ApplicationService.getStat(field,"0",0)   ;  
}
	/*@GetMapping ("/stats")
	public Object filtri (@RequestParam String fieldName, String operator, Object value) {
		return ApplicationService.filterField(fieldName, operator, value);
		}*/ 
	
	@RequestMapping(value= "/stats/{field}/{operator}/{value}", method=RequestMethod.GET)
	public Object filtri(@PathVariable String field,@PathVariable String operator,@PathVariable String value ){
		  
		if (field.equals("maschi") || field.equals("femmine")) {
			 int result= Integer.parseInt(value);
			 return ApplicationService.getStat(field,operator,result);
		}else if (field.equals("patologia") || field.equals("territorio") || field.equals("periodo")) {
			return ApplicationService.getStat(field,operator,value);}
		else {objs=new HashMap(){{ put("type", "Campo inesistente"); put("result", "ERRORE");}};
		return objs;}
	
		
	
	
	}
		
	
		
	

	
}



