package practice2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadFileExampleFortythree {

	public static void main(String[] args) {
		String filePath = "sample.txt";

		File file = new File(filePath);

		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write("This is fullstack java.");
			writer.newLine();
			writer.write("specialization react.");
			writer.newLine();
			writer.write("i am Vishwas from batch 1.");
		} catch (IOException e) {
			System.out.println("Error creating or writing to file: " + e.getMessage());
			return;
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Error reading the file: " + e.getMessage());
		}
	}
}
/*This is fullstack java.
specialization react.
i am Vishwas from batch 1.*/