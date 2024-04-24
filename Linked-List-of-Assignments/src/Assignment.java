
/* Class for the Assignment object with getter and setter methods.
 * 
 * Ben Stephen
 * Chad Wu
 * 
 * October 22, 2018
 */

public class Assignment {
	
	//Instance variables.
	private String name;
	private int dueDate;
	private String description;
	
	//Default constructor of the Assignment object.
	public Assignment() {
		name = null;
		dueDate = 0;
		description = null;
	}
	
	//Constructor of the Assignment object with parameters.
	public Assignment(String name, int dueDate, String description) {
		this.name = name;
		this.dueDate = dueDate;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}