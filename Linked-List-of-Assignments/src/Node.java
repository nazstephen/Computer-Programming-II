
/* Node class with getter and setter methods.
 * 
 * Ben Stephen
 * Chad Wu
 * 
 * October 22, 2018
 */

public class Node {
	
	//Instance variables.
	private Assignment assignment;
	private Node next;
	
	//Default constructor of the Node.
	public Node() {
		assignment = null;
		next = null;
	}
	
	//Constructor of the Node with parameters.
	public Node(Assignment newAssignment) {
		assignment = newAssignment;
		next = null;
	}
	
	//Constructor of the Node with parameters.
	public Node(Assignment newAssignment, Node newNode) {
		assignment = newAssignment;
		next = newNode;
	}
	
	public Assignment getAssignment() {
		return assignment;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setAssignment(Assignment newAssignment) {
		assignment = newAssignment;
	}
	
	public void setNext(Node newNode) {
		next = newNode;
	}
}