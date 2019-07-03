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
	private static Vector<Metadata> metadati = new Vector<Metadata>();

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

}