package com.tuenti.challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberReader___ {

	/** The Constant MAX_LINES. */
	private static final int MAX_LINES = 100000;
	

	/**
	 * Reads the file and implement the Sieve of Eratosthenes algoritm
	 * at the end calculates permutations of primes
	 * 
	 * @param file
	 *            the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void readFile(String file) throws IOException {

		
		
		FileInputStream fin = new FileInputStream(file);

	    int len;
	   
	    
	    byte data[] = new byte[24];

	    // Read bytes until EOF is encountered.
	    do {
	      len = fin.read(data);
	      for (int j = 0; j < len; j++){
	    	  int value = data[j];
	    	  //int value = data[j+0] & 0xFF;
	    	    //value |= (data[j+1] *100) & 0xFFFF;
	    	   //value |= (data[j+0] << 16) & 0xFFFFFF;
	    	  // value |= (data[j+3] << 24) & 0xFFFFFFFF;
	    	    
	      	//  System.out.println( data[j]);
	      	  System.out.println(value);
	      	  System.out.println(primeFactors(value));
	      }
	        //System.out.printf("%02X ", data[j]);
	    } while (len != -1);
		
		BufferedReader br;
		String line;

		br = new BufferedReader(
				new InputStreamReader(new FileInputStream(file)));

		

		Integer numLines = Integer.parseInt(br.readLine().trim());

		for (int l = 0; l < numLines && l < MAX_LINES; l++) {
			line = br.readLine();
			if (line != null && !line.trim().equals("")) {

				String[] numbers = line.split(" ");

				System.out.println(numbers);
				

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
	        factors.add(i);
	        n /= i;
	      }
	    }
	    if (n > 1) {
	      factors.add(n);
	    }
	    return factors;
	  }

	

}
