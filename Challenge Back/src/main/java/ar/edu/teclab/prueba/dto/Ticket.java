package ar.edu.teclab.prueba.dto;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
	
	private List<Comment> comments = new ArrayList();
	
	private int next_page;
	
    private int previous_page;
    
    private int count;
    
    

	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public int getNext_page() {
		return next_page;
	}



	public void setNext_page(int next_page) {
		this.next_page = next_page;
	}



	public int getPrevious_page() {
		return previous_page;
	}



	public void setPrevious_page(int previous_page) {
		this.previous_page = previous_page;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public Ticket() {
		super();
	}

	

}
