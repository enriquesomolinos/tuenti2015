
import java.io.IOException;

import com.tuenti.challenge.NumberReader;

/**
 * The Class Challenge2.
 */
public class Challenge2 {

	/**
	 * The main method. Use with -Xmx1024m -Xms512m arguments for large numbers
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		NumberReader theBufferReader = new NumberReader();

		try {

			theBufferReader.readFile("data/submitInput.txt");

		} catch (IOException e) {
			System.out.println("Error while reading the file");
		}

	}

}
