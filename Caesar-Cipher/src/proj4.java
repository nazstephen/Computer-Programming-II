
/* Program that encrypts/decrypts a user inputed message using a Caesar cipher with 
 * multiple keys in a list created by the user. Each character in the message is shifted 
 * by a different key value from the list. If the message is longer than the list of key 
 * values, we start using the key over again from the beginning. After, the program takes 
 * the encoded message, decodes it and prints it out. In this program we only consider the 
 * printable characters with the ASCII character numbers from 32 to 126.
 * 
 * Ben Stephen
 * Chad Wu
 * 
 * November 25, 2018
 */

import java.util.*;

public class proj4 {
	//Method that encrypts the user inputed message.
	public static String encrypt(String message, Queue keys) {
		String code = "";
		for (int i = 0; i < message.length(); i++) {
			char character = message.charAt(i);
			int key = (int)keys.dequeue();
			int val = (int)character + key;
			while (val > 126)
				val = (val - 126) + 31;
			while (val < 32)
				val = 126 - (31 - val);
			keys.enqueue(key);
			char encryptedVal = (char)val;
            code += encryptedVal;
		}
		
		return code;
	}
	
	//Method that decrypts the encrypted message.
	public static String decrypt(String code, Queue keys2) {
		String decodedMessage = "";
		for (int i = 0; i < code.length(); i++) {
			char character = code.charAt(i);
			int key = (int)keys2.dequeue();
			int val = (int)character - key;
			while (val > 126)
				val = (val - 126) + 31;
			while (val < 32)
				val = 126 - (31 - val);
			keys2.enqueue(key);
			char decryptedVal = (char)val;
			decodedMessage += decryptedVal;
		}
		
		return decodedMessage;
	}
	
	public static void main(String[] args) {
		//Creates a scanner.
		Scanner input = new Scanner(System.in);
		boolean loop = true;
		
		do {
			try {
				//Asks the user to input how many key values there will be.
				System.out.println("Enter the number of key values:");
				int numKeys = input.nextInt();
				
				//Adds user inputed values into the queues.
				System.out.println("Enter the individual key values:");
				
				//Creates two queues of key values, one to
			    //encrypt the message and one to decrypt the code.
			    Queue keys = new Queue();
			    Queue keys2 = new Queue();
			    for(int i = 0; i < numKeys; i++) {
			    	int key = input.nextInt();
				    keys.enqueue(key);
				    keys2.enqueue(key);
			    }
			    
			    //Asks the user to input the message to be encrypted/decrypted.
			    System.out.println("Enter a string to be encoded:");
			    input.nextLine();
			    String message = input.nextLine();
			    
			    //Prints out the encoded message.
			    System.out.println("The encoded message:");
			    String code = encrypt(message, keys);
			    System.out.println(code);
			
			    //Prints out the decoded message.
			    System.out.println("The decoded message:");
			    String decoded = decrypt(code, keys2);
			    System.out.println(decoded);
			
			    //Asks the user if they would like to run the program again.
			    System.out.println("\nAnother run of the program (y/n)?");
			    boolean valid = false;
			    
			    while (!valid) {
			    	String in = input.nextLine();
			    	if(in.charAt(0) == 'y' || in.charAt(0) == 'Y') {
			    		valid = true;
			    		loop = true;
			    	}
			    	
			    	else if(in.charAt(0) == 'n' || in.charAt(0) == 'N') {
			    		valid = true;
			    		loop = false;
			    	}
			    	
			    	else {
			    		System.out.print("Input not valid, try again.");
			    		valid = false;
			    	}
			    }
			}
			
			//Catches InputMismatchException.
			catch(InputMismatchException e) {
				System.out.println("Invalid input, try again!\n");
				input.next();
			}
		}
		
		//Loops the program for as many times as the user wants.
		while (loop);
	}
}