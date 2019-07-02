package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import static java.lang.String.format;

@Component
public class ApplicationService {

	private static Vector<Tumore> tumori = new Vector<Tumore>();

	static {
		//Initialize Data
		Tumore t1 = new Tumore("2011-2011", "081001", "Tumori maligni", 162 , 167);
	/*	Tumore t2 = new Course("Course2", "Spring MVC", "10 Examples",
				Arrays.asList("Learn Maven", "Import Project", "First Example",
						"Second Example"));
		Tumore t3 = new Course("Course3", "Spring Boot", "6K Students",
				Arrays.asList("Learn Maven", "Learn Spring",
						"Learn Spring MVC", "First Example", "Second Example"));
*/
	}

	public static Vector<Tumore> getList() {
		tumori = Serialization.parser();
		Gson json = new GsonBuilder().setPrettyPrinting().create();
	    String response = json.toJson(tumori);
	    System.out.println(response);
		
		
		tumori = Serialization.parser();
	
	    	return tumori;
	}
}