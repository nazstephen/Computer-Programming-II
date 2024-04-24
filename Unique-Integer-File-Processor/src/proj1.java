
/* Reads a file that contains a set of numbers in numerical order
 * and copies them onto another file without the repeating numbers.
 * 
 * Ben Stephen
 * Chad Wu
 * 
 * September 29, 2018
 */

import java.util.*;
import java.io.*;

public class proj1 {
  public static void main(String[] args) { 
    String currentLine1, currentLine2, inputFile, outputFile;
    boolean loop = true;
    Scanner in = new Scanner(System.in); 
    
    do {  
      // Asks user to input the file input name and file output name
      System.out.println("Please input the file you want to read (specify file extension).");
      inputFile = in.nextLine();
      System.out.println("Please give the file name for the output (specify file extension).");
      outputFile = in.nextLine();
      
      try {
        PrintWriter pw = new PrintWriter(outputFile); 
        BufferedReader br1 = new BufferedReader(new FileReader(inputFile)); 
        currentLine1 = br1.readLine();
        
        // Reads each line of the input file until there are no more lines
        while(currentLine1 != null) { 
          boolean match = false;  
          BufferedReader br2 = new BufferedReader(new FileReader(outputFile)); 
          currentLine2 = br2.readLine(); 
          
          // Reads each line of the output file until there are no more lines
          while (currentLine2 != null) { 
            // Compares the current line of the input file to the current line
            // of the output file to see if they match
            if (currentLine1.equals(currentLine2)) { 
              match = true; 
              break; 
            } 
            
            // Sets the current line being read in the output file to the next line 
            currentLine2 = br2.readLine(); 
          } 
          
          // Closes BufferedReader2 stream
          br2.close();
          
          // If the two lines don't match, then copy the current line from the 
          // input file to the output file
          if(match == false) { 
            pw.println(currentLine1); 
            pw.flush(); 
          } 
          
          // Sets the current line being read in the input file to the next line 
          currentLine1 = br1.readLine();
        }
        
        // Closes BufferedReader1 and PrintWriter streams
        br1.close(); 
        pw.close(); 
        
        // Asks if the user would like to run the program again
        System.out.println("Operation is completed, would you like to run again? (y/n)"); 
        Scanner inputAnswer = new Scanner(System.in);
        String answer = inputAnswer.nextLine();
        if (answer.equals("y") || answer.equals("Y")) {
          main(null); //Restarts the main method
        }
        
        if (answer.equals("n") || answer.equals("N")) {
          System.exit(0); 
        }
      }
      
      // Catches FileNotFoundException and restarts the main method
      catch (FileNotFoundException e) {
        System.out.println("Input file not found, please try another one!");
        loop = true;
      }
      
      // Catches IOException
      catch (IOException e) {
        System.out.println("Error while reading file!");
        e.printStackTrace();
      }
    }
    
    //Executes do block if FileNotFoundException is caught, creates partially infinite loop
    while(loop);
  }
}