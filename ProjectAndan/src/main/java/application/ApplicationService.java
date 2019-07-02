package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.String.format;

@Component
public class ApplicationService {

	private static List<Tumore> tumori = new ArrayList<>();

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

	public static List<Tumore> getList() {
		return tumori;
	}
}