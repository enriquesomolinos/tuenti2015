package com.tuenti.challenge;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import com.google.common.primitives.UnsignedInteger;
import com.google.common.primitives.UnsignedInts;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentReader.
 */
public class CPUReader {

	
	/**
	 * Read the student file.
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

		/*
		 * get getClass() .getResourceAsStream(file),
		 * Charset.forName("UTF-8")));
		 */

		String base64string = br.readLine();
		
		byte[] decoded = Base64.decodeBase64(base64string);
		BitSet bitSet = BitSet.valueOf(decoded);
		
		 List<Boolean> bytelist = new ArrayList<Boolean>(decoded.length*8);
		for (int i = 0; i < decoded.length; i++) {
			bytelist.addAll(byte2bits(decoded[i]));
		}
		
		Integer numLines = Integer.parseInt(br.readLine().trim());
		int bufferPosition = 0;
		for (int i = 0; i < numLines && i < numLines; i++) {
			line = br.readLine();
			if (line != null && !line.trim().equals("")) {

				boolean reverse = false;
				boolean littleendian = false;
				if (line.contains("BR")) {
					reverse = true;
					line = line.replaceAll("BR", "");
					littleendian = false;
				} else if (line.contains("LR")) {
					reverse = true;
					line = line.replaceAll("LR", "");
					littleendian = true;
				} else if (line.contains("L")) {
					littleendian = true;
					line = line.replaceAll("L", "");
					reverse = false;
				} else if (line.contains("B")) {
					reverse = false;
					line = line.replaceAll("B", "");
					littleendian = false;
				}
				int bytesNumber = Integer.parseInt(line);
				
				//int offset = 8-bytesNumber%8;
				
				BitSet currentNumber = new BitSet(((bytesNumber/8)+1)*8);
				if(littleendian){
					for (int j = 0; j <bytesNumber; j++) {
						
						currentNumber.set(j,bytelist.get(bufferPosition + j));
					}
				}
				else{
					for (int j = ((bytesNumber/8)+1)*8-(bytesNumber); j <((bytesNumber/8)+1)*8; j++) {
						
						currentNumber.set(((bytesNumber/8)+1)*8-j,bytelist.get(bufferPosition + j));
					}
					
					for (int j = 0; j<((bytesNumber/8)+1)*8; j++) {
						if(j%4==0){
							System.out.print(" ");							
						}
						if(currentNumber.get(j)){
							System.out.print("1");
						}else{
							System.out.print("0");
						}
					}
				}
					//System.out.println(ByteBuffer.wrap(currentNumber.toByteArray()).order(ByteOrder.BIG_ENDIAN).getInt());
				/*BitSet currentNumber = bitSet.get(bufferPosition,
						bufferPosition + bytesNumber);*/
				
				
				System.out.println(currentNumber.length());
				bufferPosition = bufferPosition + bytesNumber;
				
				
				
				byte[] numberNoOrder = currentNumber.toByteArray();
				for (int j = 0; j < numberNoOrder.length; j++) {
					System.out.print(String.format("%02X ", numberNoOrder[j]));
					//System.out.print(Integer.toBinaryString(numberNoOrder[j]).substring(Integer.SIZE - Byte.SIZE));
					//System.out.println("");
				}
				
				System.out.println("");
				
				
				
				//1B96C1E9
				//shift last byte offset position
				//numberNoOrder[numberNoOrder.length-1]=(byte) (numberNoOrder[numberNoOrder.length-1] >>offset);
				/*for (int j = 0; j < numberNoOrder.length; j++) {
					System.out.print(String.format("%02X ", numberNoOrder[j]));
				}*/
				
				
				//44C1D32
				
				if (littleendian) {
					numberNoOrder=wrapArray(numberNoOrder);
					numberNoOrder[0]+=1;
				} else{
					System.out.println("convertido a bigendian: "+byteArrayToInt(numberNoOrder,true));
				}
				//UnsignedInteger a = new UnsignedInteger(new BigInteger(numberNoOrder).intValue());
				/*byte[] a = new byte[4];				
				a[3]=(byte)0xE9;
				a[2]=(byte)0xC1;
				a[1]=(byte)0x96;
				a[0]=0x1B;
				System.out.println(   Hex.encodeHex( a ) );
				System.out.println(new BigInteger(a).intValue());
				
				byteArrayToInt(a);*/
				
				//numberNoOrder[0]+=1;
				System.out.println(new BigInteger(numberNoOrder).intValue() );
				
				//long n = byteArrayToInt(bb.array());
				/*if (reverse) {
					n = Integer.reverse(n);
				}*/
				//System.out.println(n);

				// reverse
			}
		}

		// Done with the file
		br.close();
		br = null;
	}
	
	public static int toInt( byte[] bytes ) {
	    int result = 0;
	    for (int i=0; i<4; i++) {
	      result = ( result << 8 ) - Byte.MIN_VALUE + (int) bytes[i];
	    }
	    return result;
	  }

	public static byte[] wrapArray(byte[] array){
		byte[] output = new byte[array.length];
		for (int i = 0; i < output.length; i++) {
			output[output.length-1-i]=array[i];
		}
		return output;
	}
	
	public int byteArrayToInt(byte[] valor, boolean bigEndian){
	     if(valor. length < 4){
	          throw new ArrayIndexOutOfBoundsException(valor. length);
	     }
	     int a, b, c, d;
	     if(bigEndian){
	          a = (valor[0] & 0xFF) << 24;
	          b = (valor[1] & 0xFF) << 16;
	          c = (valor[2] & 0xFF) << 8;
	          d =  valor[3] & 0xFF;
	     } else{
	          a = (valor[3] & 0xFF) << 24;
	          b = (valor[2] & 0xFF) << 16;
	          c = (valor[1] & 0xFF) << 8;
	          d =  valor[0] & 0xFF;
	     }
	     return  a | b | c | d;
	}
	
	public static long byteArrayToInt(byte[] encodedValue) {
	    int index = 0;
	    int value = 0;
	    if(encodedValue.length==4){
		    
		    value = (encodedValue[index++]) << Byte.SIZE * 3;
		    value ^= (encodedValue[index++] & 0xFF) << Byte.SIZE * 2;
		    value ^= (encodedValue[index++] & 0xFF) << Byte.SIZE * 1;
		    value ^= (encodedValue[index++] & 0xFF);
	    }else if(encodedValue.length==3){
		    
		    value =  (encodedValue[index++] & 0xFF) << Byte.SIZE * 2;
		    value ^= (encodedValue[index++] & 0xFF) << Byte.SIZE * 1;
		    value ^= (encodedValue[index++] & 0xFF);
	    }else if(encodedValue.length==2){
		    
		    value = (encodedValue[index++] & 0xFF) << Byte.SIZE * 1;
		    value ^= (encodedValue[index++] & 0xFF);
	    }else if(encodedValue.length==1){
		    
		    value = (encodedValue[index++] & 0xFF);
	    }
	   
	    
	    return value & (-1L >>> 32);
	}
	
	public byte[] list2bytes(List<Boolean> bitlist){
		
		byte[] bytes = new byte[Math.round(bitlist.size()/8)];
		for (int i = 0; i < Math.round(bitlist.size()/8); i++) {
			
		}	
		
		
		return bytes;
	}
	
	public List<Boolean> byte2bits(byte theByte){
		
			
		 List<Boolean> bytelist = new ArrayList<Boolean>(8);
		 bytelist.add( (theByte & 0x1) != 0);
		 bytelist.add(  (theByte & 0x2) != 0);
		 bytelist.add(  (theByte & 0x4) != 0);
		 bytelist.add(  (theByte & 0x8) != 0);
		 bytelist.add(  (theByte & 0x10) != 0);
		 bytelist.add( (theByte & 0x20) != 0);
		 bytelist.add(  (theByte & 0x40) != 0);
		 bytelist.add(  (theByte & 0x80) != 0);

		 return bytelist;
	}
}
