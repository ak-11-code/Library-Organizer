import java.io.*;
public class Library {
	//Initialize instance variables to be used in the program
	
	private String bookTitle; //Title of book
	private String authorName; //Name of author
	private int bookYear; //Year book was released 
	
	//Create constructors/getters/setters
	//Constructor for library if called without parameters
	public Library() {
		bookTitle = "Empty";
		authorName = "Empty";
		bookYear = 0;
	}
	//Constructor for library if called with parameters
	//Has parameters that align with the instance variables 
	public Library(String bookTitle, String authorName, int bookYear) {
		this.bookTitle = bookTitle;
		this.authorName = authorName;
		this.bookYear = bookYear;
	}
	//Getter for bookTitle
	public String getBookTitle() {
		return bookTitle;
	}//getBookTitle
	
	//Setter for bookTitle
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}//setBookTitle
	
	//Getter for authorName
	public String getAuthorName() {
		return authorName;
	}//GetAuthorName
		
	//Setter for authorName
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}//SetAuthorName
	
	//Getter for bookYear
	public int getBookYear() {
		return bookYear;
	}//getbookYear
			
	//Setter for bookYear
	public void setBookYear(int bookYear) {
		this.bookYear = bookYear;
	}//setbookYear
	
	public String toString() {
		return(bookTitle+"\t\t"+authorName+"\t\t"+bookYear);
	}
	
	
		
}

