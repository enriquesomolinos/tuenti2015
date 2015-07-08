

import java.io.IOException;

import com.tuenti.challenge.TheBufferReader;

/**
 * The Class Challenge1.
 */
public class Challenge1 {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		
		
		
		TheBufferReader theBufferReader = new TheBufferReader();
		

		try {

			theBufferReader.readFile("data/submitInput.txt");

		} catch (IOException e) {
			System.out.println("Error while reading the file");
		}

		
	}

}
