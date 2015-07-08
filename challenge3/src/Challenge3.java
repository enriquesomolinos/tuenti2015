
import java.io.IOException;

import com.tuenti.challenge.NumberReader;
import com.tuenti.challenge.NumberReader___;

/**
 * The Class Challenge2.
 */
public class Challenge3 {

	/**
	 * The main method. 
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		NumberReader theBufferReader = new NumberReader();

		try {

			theBufferReader.readFile("data/numbers.txt");

		} catch (IOException e) {
			System.out.println("Error while reading the file");
		}

	}

}
