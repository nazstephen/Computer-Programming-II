
/* Node class with getter and setter methods.
 * 
 * Ben Stephen
 * Chad Wu
 * 
 * November 25, 2018
 */

public class Node {
	//Instance variables.
	private Object item;
	private Node next;
	
	//Default constructor of the Node.
	public Node(Object newItem) {
		item = newItem;
		next = null;
	}
	
	//Constructor of the Node with parameters.
	public Node(Object newItem, Node newNode) {
		item = newItem;
		next = newNode;
	}
	
	public Object getItem() {
		return item;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setItem(Object newItem) {
		item = newItem;
	}
	
	public void setNext(Node newNode) {
		next = newNode;
	}
}   