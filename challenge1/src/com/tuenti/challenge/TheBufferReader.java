package com.tuenti.challenge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentReader.
 */
public class TheBufferReader {

	
	/** The Constant MAX_LINES. */
	private static final int MAX_LINES = 100000;
	/** The Constant SEPARATOR. */
	private static final String SEPARATOR = ",";

	/**
	 * Read the student file.
	 *
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void readFile(String file) throws IOException {
		
		BufferedReader br;
		String line;
		
		br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		/*get  getClass()
				.getResourceAsStream(file), Charset.forName("UTF-8")));*/

		
		Integer numLines = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < numLines && i < MAX_LINES; i++) {
			line = br.readLine();
			if (line != null && !line.trim().equals("")) {

				
				long value = Long.parseLong(line);
				
				System.out.println(Math.round(1.0*value/2));
				
				
			}
		}
		
		
		

		// Done with the file
		br.close();
		br = null;
	}

}
