package com.tuenti.challenge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NumberReader {

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

		BufferedReader br;
		String line;

		br = new BufferedReader(
				new InputStreamReader(new FileInputStream(file)));

		

		Integer numLines = Integer.parseInt(br.readLine().trim());

		for (int l = 0; l < numLines && l < MAX_LINES; l++) {
			line = br.readLine();
			if (line != null && !line.trim().equals("")) {

				String[] numbers = line.split(" ");

				int topNumber = Integer.parseInt(numbers[1]);
				int minNumber = Integer.parseInt(numbers[0]);
				
				
			
		        boolean[] isPrime = new boolean[topNumber + 1];
		        for (int i = 2; i <=topNumber; i++) {
		            isPrime[i] = true;
		        }

		        // mark non-primes <= N using Sieve of Eratosthenes
		        for (int i = 2; i*i <= topNumber; i++) {

		            // if i is prime, then mark multiples of i as nonprime
		            // suffices to consider mutiples i, i+1, ..., N/i
		            if (isPrime[i]) {
		                for (int j = i; i*j <= topNumber; j++) {
		                    isPrime[i*j] = false;
		                }
		            }
		        }

		        // count primes
		        int primes = 0;
		        List<Integer> miPrimes = new ArrayList<Integer>();
		        for (int i = 2; i <= topNumber; i++) {
		            if (isPrime[i]){
		            	miPrimes.add(i);
		            }
		        }
		        
		        primes=0;
		        HashMap<Integer,Boolean> validated = new HashMap<Integer,Boolean>();
		        for(int y=0;y<miPrimes.size();y++){
		        	
		        	innerLoop:
		        		
		        	for(int z=0;z<miPrimes.size();z++){
		        		int yPrime = miPrimes.get(y);
		        		int zPrime = miPrimes.get(z);
		        		
		        		if(yPrime*zPrime>topNumber){
		        			break innerLoop;
		        		}
		        		if(yPrime*zPrime<=topNumber && yPrime*zPrime>=minNumber &&
		        			validated.get(yPrime*zPrime)==null){
		        			primes++;
		        			validated.put(yPrime*zPrime, true);
		        		}
		        		
		        	}
		        }
				
		        System.out.println(primes);
				

			}
		}

		// Done with the file
		br.close();
		br = null;
	}

	

}
