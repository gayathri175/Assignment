package practice2;


import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BatchmatesThirtyseve {

	public static void main(String[] args) {

		String[] batchMates = {
			"gayathri",
			"ranjith",
			"vishwas",
			"honey",
			"pradhyuma",
			"prudhvy",
			"menaka",
			"Harshita Jain"
		};

		String filename = "batchmates.txt";

		try {
			FileWriter writer = new FileWriter(filename);
			for (String name : batchMates) {
				writer.write(name + "\n");
			}
			writer.close();

			System.out.println("Batch mates written to file.\nDisplaying contents:");

			FileReader reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			reader.close();
		} catch (IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
	}
}
/*Batch mates written to file.
Displaying contents:
gayathri
ranjith
vishwas
honey
pradhyuma
prudhvy
menaka
Harshita Jain
*/