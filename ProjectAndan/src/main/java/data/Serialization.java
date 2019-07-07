package data;
import java.io.*;
import java.util.*;
/**
 * Effettua il parsing del file csv nella classe Tumore
 * @author Andrea Giuliani Daniele Pallini
 *
 */
public class Serialization {

	public Serialization() {		
	}

	public static Vector<Tumore> data(){
		List<List<String>> records = new ArrayList<>();
		Vector<Tumore> v = new Vector<Tumore>();
		try (BufferedReader br = new BufferedReader(new FileReader("t1.csv"))) {
			String line = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				// System.out.println(values.length);
				records.add(Arrays.asList(values));
				v.add(new Tumore(values[0], values[1], values[2] , Integer.parseInt(values[3]), Integer.parseInt(values[4])));
			}
			br.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

	   return v;	   
	}

}

