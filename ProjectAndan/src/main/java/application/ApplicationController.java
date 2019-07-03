package application;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
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
	
	@Autowired
    private ApplicationService applicationService;
	
	@GetMapping("/data")
    public Vector<Tumore> getAll() {
        return ApplicationService.getList();
	}
	@GetMapping("/metadata/")
    public Vector<Metadata> getM() {
        return ApplicationService.getMeta();
	}

}

/*
	}
	@GetMapping("/metadata/")
	public List<Tumore> getMetadataForTumore(@PathVariable String studentId) {
		return studentService.retrieveCourses(studentId);
	}
	*
	*/
	
