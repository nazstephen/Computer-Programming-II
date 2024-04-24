
/* Program that allows to user to add an assignment into a linked list in order of due date.
 * Lets the user remove an assignment and displays all assignments in the list.
 * Can find and display the earliest assignment in the list.
 * 
 * Ben Stephen
 * Chad Wu
 * 
 * October 22, 2018
 */

import java.util.*;

public class proj2 {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		//Creates an AssignmentList.
		AssignmentList list = new AssignmentList();
		boolean loop = true;
		do {
			
			//Displays the user-friendly menu.
            System.out.println("1) Add a new assignment.");
            System.out.println("2) Remove an assignment.");
            System.out.println("3) Display the assignments.");
            System.out.println("4) Find the assignment(s) that is due the earliest.");
            System.out.println("5) Exits the program.");
            System.out.println("Type in 1, 2, 3, 4 or 5.");
            
            String input = s.next(); 
            switch (input) {
            
            //Asks the user for the parameters of the assignment and adds it into to the list.
            //(In order of due date)
            case "1" : 
            	Assignment newAssignment = new Assignment();
            	Node newNode = new Node(newAssignment);
            	
            	//Asks and assigns the name of the Assignment.
                System.out.println("Name of the assignment: ");
                s.nextLine();
                String name = s.nextLine();
                newNode.getAssignment().setName(name);
                
                //Asks and assigns the due date of the Assignment.
                boolean invalid = true;
                do { 
                	System.out.println("Day the assignment is due: ");
                	
                	//Tries the input value to see if it is of type int.
                	try {
                		int dueDate = s.nextInt();
                		
                		//Checks to see if the day entered by the user fits into a calendar month.
                		while (dueDate < 1 || dueDate > 31) {
                			System.out.println("Invalid input, does not fit within a calendar month. "
                			           + "Try again.");
                			dueDate = s.nextInt();
                		}
                		
                		newNode.getAssignment().setDueDate(dueDate);
                		invalid = false;
                	}
                	
                	//Catches InputMismatchException and asks user for another input.
                	catch(Exception e) {
                		System.out.println("Invalid input, must be an integer. Try again.");
                		invalid = true;
                		s.next();
                	}
                }
                //Keeps asking user for input until user enters an integer.
                while (invalid);
                
                //Asks and assigns a description to the assignment.
                System.out.println("Description of the assignment: ");
                s.nextLine();
                String description = s.nextLine();
                newNode.getAssignment().setDescription(description);
                
                list.addAssignment(newNode.getAssignment());  
                System.out.println("Assignment \"" + newNode.getAssignment().getName() 
                		           + "\" was added.\n");
                break;    
                
            //Removes an assignment from the list.
            //(According to the position entered in by the user)
            case "2" : 
                System.out.println("Assignment you would like to remove? "
                		           + "(By position on the list): ");
                
                int posi = s.nextInt();
                
                //Checks to see if the list is empty.
                if(list.listLength() == 0)
            		System.out.println("No assignments in the list.");
                else {
                	
                	//Checks to see if the position entered by the user is within bounds.
                	while (posi < 1 || posi > list.listLength()) {
                		System.out.println("Position entered does not exist. Try again.");
                		posi = s.nextInt();
                	}
                	
                	list.removeAssignment(posi);
                	System.out.println("Assignment #" + posi + " was removed.\n");
                }
                break;  
                
            //Displays the assignments in the list.   
            case "3" :
            	System.out.println("List of the assignments: ");
            	
            	//Checks to see if the list is empty.
            	if(list.listLength() == 0)
            		System.out.println("No assignments in the list.\n");
            	else
            		list.displayAssignmentList();
                break;         
            
            //Displays the the assignment(s) with the nearest due date.
            case "4" :
            	System.out.println("Assignment(s) with the earliest due date: ");
            	
            	//Checks to see if the list is empty.
            	if(list.listLength() == 0)
            		System.out.println("No assignments in the list.\n");
            	else
            		list.earliestAssignment();
            	break;
                
             default : 
                System.out.println("Invalid input. Try again.\n");
                break; 
             
             case "5" :
             	System.out.println("Now exiting the program.");
             	loop = false;
            }
		}
		
		while (loop);
	}
}