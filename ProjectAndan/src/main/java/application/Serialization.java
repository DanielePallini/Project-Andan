package application;
import java.io.*;
import java.util.*;

public class Serialization {

	public Serialization() {
		
	}

	/*public static void parser() {
		Tumore t = new Tumore("2011-2011", "081001", "Tumori maligni", 162 , 167);
	}
	
	
		try {
			FileOutputStream fileOut = new FileOutputStream("tumore.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(t);
			out.close();
			fileOut.close();
			//System.out.printf("Serialized data is saved in tumore.ser");
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
	}*/


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

