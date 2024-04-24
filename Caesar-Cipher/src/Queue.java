
/* Creates a reference based Queue class which can enqueue, dequeue and peek items.
 * 
 * Ben Stephen
 * Chad Wu
 * 
 * November 25, 2018
 */

public class Queue {
	//Instance variables.
	private Node b;
	
	//Constructor of the Queue.
	public Queue() {
		b = null;
	}
	
	//Method that shows if the Queue is empty.
	public boolean QueueIsEmpty() {
		return(b == null);
	}
	
	//Method that adds an item into the Queue.
	public void enqueue(Object newItem) {
		Node newNode = new Node(newItem);
		
		if(QueueIsEmpty()) {
			newNode.setNext(newNode);
			b = newNode;
		}
		
		else {
			newNode.setNext(b.getNext());
			b.setNext(newNode);
			b = newNode;
		}
	}
	
	//Method that removes an item from the Queue.
	public Object dequeue()
			throws RuntimeException {
		
        if(!QueueIsEmpty()) {
        	Node temp = b.getNext();
        	
        	if(temp == b)
        		b = null;
        	else {
        		b.setNext(temp.getNext());
        		temp.setNext(null);
        	}
        	
        	return temp.getItem();
        }
        
        else
			throw new RuntimeException("");
	}
	
	//Method that looks at the item at the beginning of the Queue.
	public Object peek()
		throws RuntimeException {
		
		if(!QueueIsEmpty())
			return(b.getNext().getItem());
		else
			throw new RuntimeException("");
	}
}