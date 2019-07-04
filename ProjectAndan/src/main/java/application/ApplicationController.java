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
	private static Object obj = new Object();
	
	@ResponseBody
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public Object missingParamterHandler(Exception exception) {
	    // exception handle while specified arguments are not available requested service only. it handle when request is as api json service       
	    return  new HashMap() {{ put("result", "failed"); put("type", "error");}};
	} 
	
	
	@Autowired
    private ApplicationService applicationService;
	
	@GetMapping("/data")
    public Vector<Tumore> getAll() {
        return ApplicationService.getList();
	}
	@GetMapping("/metadata")
    public Vector<Metadata> getM() {
        return ApplicationService.getMeta();
	}
   
	@GetMapping("/stats")

    public Object statsInt(@RequestParam String field) {
         	 switch (field) {
          	 case "maschi" :	{Object obj = new Object () ;
          		                 obj = ApplicationService.getStats(field);
          	  		                        return obj;
          	  		                        }
          	 case "femmine" : {Object obj = new Object () ;
               obj = ApplicationService.getStats(field);
                   return obj;
                   }
          	 
          	 case "periodo" : {Object obj = new Object () ;
          		 
          		 obj=ApplicationService.getCount(field);
          		 return obj;}
          	 case "patologia" : {Object obj = new Object () ;
      		 
      		 obj=ApplicationService.getCount(field);
      		 return obj;}
          	 case "territorio" : {Object obj = new Object () ;
      		 
      		 obj=ApplicationService.getCount(field);
      		 return obj;}
         }
		
	        return obj;
	        }
	

}



