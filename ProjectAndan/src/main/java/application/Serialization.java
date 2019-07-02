package application;
import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Serialization {
	final static String COMMA_DELIMITER = ",";

	public Serialization() {
		// TODO Auto-generated constructor stub
	}

	public static Vector<Tumore> parser() {
		Tumore t = new Tumore("2011-2011", "081001", "Tumori maligni", 162 , 167);
   
	
		
		try {
			FileOutputStream fileOut = new FileOutputStream("tumore.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(t);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in tumore.ser");
		} catch (IOException i) {
			i.printStackTrace();
		} 

		Tumore t1 = null;		
		try {
			FileInputStream fileIn = new FileInputStream("tumore.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			t1 = (Tumore) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
	//		return;
		} catch (ClassNotFoundException c) {
			System.out.println("Tumore class not found");
			c.printStackTrace();
		//	return;
		}

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
	//		return;
		}

	   
	    
	   return v;
	   
	
		

		/* List<List<String>> records2 = new ArrayList<>();
		try (Scanner s = new Scanner(new File("t1.csv"));) {
			while (s.hasNextLine()) {
				records2.add(getRecordFromLine(s.nextLine()));
			}
			s.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} */
	}
	
/*
	 private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter("COMMA_DELIMITER");
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	} 
*/
}
