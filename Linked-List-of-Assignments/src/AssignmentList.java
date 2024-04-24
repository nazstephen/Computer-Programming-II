
/* Creates the AssignmentList class which can perform operations such as adding an assignment,
 * removing an assignment, displaying the contents of the list and finding and displaying the
 * earliest assignment in the list.
 * 
 * Ben Stephen
 * Chad Wu
 * 
 * October 22, 2018
 */

public class AssignmentList{
	
	//Instance variables.
	private Node head;
	private int numAssignments;
	
	//Constructor of the AssignmentList.
	public AssignmentList() {
		head = null;
		numAssignments = 0;
	}
	
	public int listLength() {
		return numAssignments;
	}
	
	//Method that inserts an assignment into the list in order of due date.
	public void addAssignment(Assignment newAssignment) {
		Node newNode = new Node(newAssignment);
		
		//Special case that adds an assignment to the beginning of the list.
        if (head == null || newNode.getAssignment().getDueDate() < 
            head.getAssignment().getDueDate()) { 
        	newNode.setNext(head); 
            head = newNode; 
        } 
        
        else {
            Node curr = head; 
            
            while (curr.getNext() != null && 
            	   curr.getNext().getAssignment().getDueDate() <= 
            	   newNode.getAssignment().getDueDate())
            	curr = curr.getNext();
            
            newNode.setNext(curr.getNext());
            curr.setNext(newNode);
        } 
        
        numAssignments++;
	}
	
	//Locates the assignment based on its position in the list.
	private Node locate(int posi) {
		Node curr = head; 
		
		while(posi > 1) {
			curr = curr.getNext();
			posi--;
		}
		
		return curr;
	}
	
	//Method that removes an assignment in the list according to position.
	public void removeAssignment(int posi)
		throws IndexOutOfBoundsException {
		
		if(posi >= 1 && posi <= numAssignments) {
			Node curr;
			
			//Special case that removes an assignment at the beginning of the list.
			if(posi == 1) {
				curr = head;
				head = head.getNext();
			}
			
			else {
				Node prev = locate(posi - 1);
				curr = prev.getNext();
				prev.setNext(curr.getNext());
			}
			
			numAssignments--;
			curr.setNext(null);
			curr = null;
		}
		
		else
			throw new IndexOutOfBoundsException("Position does not exist in the list!");
	}
	
	//Method that displays the contents of the list.
	public void displayAssignmentList() {
	    Node curr = head;
	    int posi = 1;

	    while(curr != null){
	    	System.out.println(posi + ") " + curr.getAssignment().getName() + 
	    			           "\nDue on day: " + curr.getAssignment().getDueDate() + 
	    			           "\nDescription: " + curr.getAssignment().getDescription() + "\n");
	        curr = curr.getNext();
	        posi++;
	    }
	}
	
	//Method that displays the assignment(s) with the nearest due date.
	public void earliestAssignment( ) {
		Node curr = head;
		int posi = 1;
		int date = head.getAssignment().getDueDate();
		
		while(curr != null && curr.getAssignment().getDueDate() == date){
			System.out.println(posi + ") " + curr.getAssignment().getName() + 
					           "\nDue on day: " + curr.getAssignment().getDueDate() + 
					           "\nDescription: " + curr.getAssignment().getDescription()+ "\n");
			curr = curr.getNext();
			posi++;
		}
	}
}