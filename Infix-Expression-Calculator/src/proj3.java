
/* Program that allows the user to input a syntactically correct infix expression.
 * Assume unary operators are illegal and the expressions contains no embedded spaces.
 * The program solves the infix expression by converting it into postfix form and then 
 * evaluating the resulting postfix expression.
 * 
 * Ben Stephen
 * Chad Wu
 * 
 * November 11, 2018
 */

import java.util.*;
import java.io.*;

public class proj3 {
	
	//Ranks operators' precedence in relation to PEMDAS
	public static int precedence(char operator) {
		switch(operator) {
		case '+':
		case '-':
			return 0;
		
		case '*':
		case '/':
			return 1;
			
		default:
			throw new RuntimeException("Illegal operator!");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		
		System.out.println("Welcome to my simple calculator!");
		
		do {
			StackRefBased stack = new StackRefBased();
			String output = "";
			System.out.println("Please enter an infix expression: ");
			String input = scan.nextLine();
			
			//Postfix to infix
			for (int i = 0; i < input.length(); i++) {
				
				//checks if char is operand; if so, append to output
				if (Character.isDigit(input.charAt(i))) {
					output = output + input.charAt(i);
					
					//checks for multi-digit numbers, places spaces in between numbers
					if (i+1 >= input.length() || !Character.isDigit(input.charAt(i+1)))
						output = output + ' ';
				}
				
				//if open parentheses is read
				else if (input.charAt(i) == '(')
					stack.push(input.charAt(i));
				
				//Garbage collection for closed parentheses
				else if (input.charAt(i) ==')') {
					while ((Character)stack.peek()!='(')
						
						output = output + (Character)stack.pop(); 
					stack.pop();
				}
				
				//if program reads operator
				else if (input.charAt(i) == '+' || 
						 input.charAt(i) == '-' || 
						 input.charAt(i) == '*' || 
						 input.charAt(i) == '/') {
					
					//checks and reads operators in correct order, based on order of ops from precedence method
					while(!stack.StackIsEmpty() && (Character)stack.peek() != '(' && 
						  precedence(input.charAt(i)) <= precedence((Character)stack.peek()))
						
						output = output + (Character)stack.pop();
					
					stack.push(input.charAt(i));
				}
			}
			
			while(!stack.StackIsEmpty())
				output = output + (Character)stack.pop();
			
			System.out.println("Postfix: " + output);
			
			//Postfix to final evaluation
			for (int i = 0; i < output.length(); i++) { 
				if (output.charAt(i) == ' ')
					continue;
				
				if (Character.isDigit(output.charAt(i))) {
					int n = 0;
					
					while(Character.isDigit(output.charAt(i))) {
						char c = output.charAt(i);
						//converts char to ints, multiplies by 10 to calculate correct magnitude of multi-digit numbers
						n = n*10 + (int)((c)-'0'); 
						c = output.charAt(i);
						i++;
					}
					
					stack.push(n);
					i--;	
				}
				
				else {
					int secondOperand = Integer.parseInt(String.valueOf(stack.pop()));
					int firstOperand = Integer.parseInt(String.valueOf(stack.pop()));
					
					//mathematical evaluation
					switch(output.charAt(i)) {
					case '+':
						stack.push(firstOperand + secondOperand);
						break;
          
					case '-':
						stack.push(firstOperand - secondOperand);
						break;
          
					case '*':
						stack.push(firstOperand * secondOperand);
						break;
            
					case '/':
						stack.push(firstOperand / secondOperand);
						break;
					}
				}
			}
			
			System.out.println("The result of the evaluation: " + stack.pop());
			
			//Asks the user if they would like to run the program again.
			System.out.println("Evalue another infx expression (y/n): ");
			boolean valid = false;
			
			while (!valid) {
				String in = scan.nextLine();
				if(in.charAt(0) == 'y' || in.charAt(0) == 'Y') {
					valid = true;
					loop = true;
				}
				
				else if(in.charAt(0) == 'n' || in.charAt(0) == 'N') {
					valid = true;
					loop = false;	
				}
				
				else {
					System.out.println("Input not valid, try again.");
					valid = false;
				}
			}
		}
		
		while (loop);
	}
}