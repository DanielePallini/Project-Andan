package application;

import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import data.Metadata;
import data.Tumore;
/**
 * Controller di Application. Sono presenti tutte le varie chiamate
 * @author Andrea Giuliani Daniele Pallini
 *
 */
@RestController
public class ApplicationController {
	
	
	
	
	
	@GetMapping("/data")
    public Vector<Tumore> getAll() {
        return ApplicationService.getList();
	}
	@GetMapping("/data/{field}/{operator}/{value}")
    public Object filtriData(@PathVariable String field,@PathVariable String operator,@PathVariable String value) {
		return ApplicationService.filtriData(field, operator, value);
	}
		
	@GetMapping("/data/{field1}/{value1}/{field2}/{value2}" )
    public Object and(@PathVariable String field1,@PathVariable String value1,@PathVariable String field2 , @PathVariable String value2) {	 
		 return ApplicationService.and(field1, value1, field2, value2);
}
	@GetMapping("/metadata")
    public Vector<Metadata> getM() {
        return ApplicationService.getMeta();
	}
   
	@GetMapping("/stats/{field}")
    public Object stats(@PathVariable String field) {
           return ApplicationService.getStat(field,"0",0)   ;  
}

	
	@GetMapping("/stats/{field}/{operator}/{value}")
	public Object filtri(@PathVariable String field,@PathVariable String operator,@PathVariable String value ){
	return ApplicationService.filtri(field, operator, value);
	}
		
	
		
	

	
}

