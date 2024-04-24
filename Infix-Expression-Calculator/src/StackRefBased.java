
/* Creates a reference based Stack class which can perform operations such as 
 * pushing, popping and peeking items.
 * 
 * Ben Stephen
 * Chad Wu
 * 
 * November 11, 2018
 */

import java.util.EmptyStackException;

public class StackRefBased {
	
	//Instance variables.
	private Node top;
	
	//Constructor of the Stack.
	public StackRefBased() {
		top = null;
	}
	
	public boolean StackIsEmpty() {
		return(top == null);
	}
	
	//Method that pushes item into the Stack.
	public void push(Object newItem) {
		top = new Node(newItem, top);
	}
	
	//Method that pops an item from the Stack.
	public Object pop()
		throws EmptyStackException {
		
		if(!StackIsEmpty()) {
			Object r = top.getItem();
			Node cur = top;
			top = top.getNext();
			cur = null;
			return r;
		}
		
		else
			throw new EmptyStackException();
	}
	
	//Method that looks at the item at the top of the Stack.
	public Object peek()
		throws EmptyStackException {
		
		if(!StackIsEmpty())
			return top.getItem();
		else 
			throw new EmptyStackException();
	}
}