package com.tuenti.challenge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentReader.
 */
public class NumberReader {

	
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

		
		Integer numLines = 30000;//Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < numLines && i < MAX_LINES; i++) {
			line = br.readLine();
			if (line != null && !line.trim().equals("")) {
					
//				String[] numbers =line.split("0");
//				for (String number : numbers) {
//					System.out.println(number);
//					System.out.println(primeFactors(Integer.parseInt(number)));
//				}
				int numeros =0;
				while(line.length()>2){
				numeros++;
					String  number = line.substring(0, 8);
					if(primeFactors(Integer.parseInt(number)).get(0)>101){
						 number = line.substring(0, 7);
					if(primeFactors(Integer.parseInt(number)).get(0)>101){
						 number = line.substring(0, 6);
					if(primeFactors(Integer.parseInt(number)).get(0)>101){
						 number = line.substring(0, 5);
						if(primeFactors(Integer.parseInt(number)).get(0)>101){
							 number = line.substring(0, 4);
								
								if(primeFactors(Integer.parseInt(number)).get(0)>101){
									 number = line.substring(0, 3);
										
										if(primeFactors(Integer.parseInt(number)).get(0)>101){
											 number = line.substring(0, 2);
												System.out.println(number);
												System.out.println(primeFactors(Integer.parseInt(number)));
												line=line.substring(2);
										}else{
											System.out.println(number);
											System.out.println(primeFactors(Integer.parseInt(number)));
											line=line.substring(3);
										}
								}else{
									System.out.println(number);
									System.out.println(primeFactors(Integer.parseInt(number)));
									line=line.substring(4);
								}
						}else{
							System.out.println(number);
							System.out.println(primeFactors(Integer.parseInt(number)));
							line=line.substring(5);
						}
					}
						else{
							System.out.println(number);
							System.out.println(primeFactors(Integer.parseInt(number)));
							line=line.substring(6);
						}
					}
					else{
						System.out.println(number);
						System.out.println(primeFactors(Integer.parseInt(number)));
						line=line.substring(7);
					}
					}
					else{
						System.out.println(number);
						System.out.println(primeFactors(Integer.parseInt(number)));
						line=line.substring(8);
					}
					
					
					/*String[] numbers = line.split("(?<=\\G...)");
					
					for (String number : numbers) {
						System.out.println(number);
						System.out.println(primeFactors(Integer.parseInt(number)));
					}*/
					
					
					
					
				}
				System.out.println(numeros);
			}
		}
		
		
		

		// Done with the file
		br.close();
		br = null;
	}
	
	public  List<Integer> primeFactors(int numbers) {
	    int n = numbers;
	    List<Integer> factors = new ArrayList<Integer>();
	    for (int i = 2; i <= n / i; i++) {
	      while (n % i == 0) {
	        factors.add(0,i);
	        n /= i;
	      }
	    }
	    if (n > 1) {
	      factors.add(0,n);
	    }
	    return factors;
	  }

}
