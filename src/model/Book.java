package model;

import java.util.*;

public class Book {
	
	private static Book bookInstance;
	private List<Contact> book;
	
	private Book(){
		book = new ArrayList<Contact>();
	}
	
	public static Book getInstance(){
		if(bookInstance == null) {
	         bookInstance = new Book();
	      }
	      return bookInstance;
	}
	
	public boolean isPresent(String firstname, String lastname){
		for(Contact c : book){
			if(c.getFirstname().equals(firstname) && c.getLastname().equals(lastname)){
				return true;
			}
		}
		return false;
	}
	
	public void add(Contact c) {
		book.add(c);
	}
	
}
