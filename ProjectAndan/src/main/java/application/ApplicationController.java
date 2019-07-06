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
	
	
	
	
	
	@GetMapping("/data")
    public Vector<Tumore> getAll() {
        return ApplicationService.getList();
	}
	@RequestMapping(value = "/data/{field}/{operator}/{value}" , method=RequestMethod.GET)
    public Object filtriData(@PathVariable String field,@PathVariable String operator,@PathVariable String value) {
		return ApplicationService.filtriData(field, operator, value);
	}
		
	@RequestMapping(value = "/data/{field1}/{value1}/{field2}/{value2}" , method=RequestMethod.GET)
    public Object and(@PathVariable String field1,@PathVariable String value1,@PathVariable String field2 , @PathVariable String value2) {	 
		 return ApplicationService.and(field1, value1, field2, value2);
}
	@GetMapping("/metadata")
    public Vector<Metadata> getM() {
        return ApplicationService.getMeta();
	}
   
	@GetMapping("/stats")
    public Object stats(@RequestParam String field) {
           return ApplicationService.getStat(field,"0",0)   ;  
}

	
	@RequestMapping(value= "/stats/{field}/{operator}/{value}", method=RequestMethod.GET)
	public Object filtri(@PathVariable String field,@PathVariable String operator,@PathVariable String value ){
	return ApplicationService.filtri(field, operator, value);
	}
		
	
		
	

	
}

