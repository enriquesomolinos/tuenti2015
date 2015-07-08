
import java.io.IOException;

import com.tuenti.challenge.CPUReader;

/**
 * The Class Challenge2.
 */
public class Challenge4 {

	/**
	 * The main method. Use with -Xmx1024m -Xms512m arguments for large numbers
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		CPUReader theBufferReader = new CPUReader();

		try {

			theBufferReader.readFile("data/sample.txt");

		} catch (IOException e) {
			System.out.println("Error while reading the file");
		}

	}

}
