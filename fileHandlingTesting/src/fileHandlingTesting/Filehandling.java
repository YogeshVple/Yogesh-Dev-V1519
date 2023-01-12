package fileHandlingTesting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Filehandling {
	
	
	public static void main(String[] args) {
		
		File myFile=  new File("D:\\test.txt");
		
		try {
			myFile.createNewFile();
			System.out.println("File Created");
		} catch (IOException e) {
			System.out.println("unable to create file");
			e.printStackTrace();
		}
		
		try {
			FileWriter fileWriter = new FileWriter("D:test.csv");
			fileWriter.write("This is file writter \n okay now bye");
			System.out.println("Writting done");
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Not working");
			
			e.printStackTrace();
		}
	}
}
