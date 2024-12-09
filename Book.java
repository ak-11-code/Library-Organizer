import java.io.*;
public class Book extends Library{ //Extension of the library class following inheritance order
	private String bookGenre;
	public static String[]books = new String[20];
	
	//Constructor for Book if called with parameters
    public Book(String bookTitle, String authorName, int bookYear, String bookGenre) {
        super(bookTitle, authorName, bookYear);
        this.bookGenre = bookGenre;
    }
    
	//Constructor for Book if called without parameters
    public Book() {
    	super();
    	bookGenre = "Empty";
    }
    
    public String getBookGenre() {
        return bookGenre;
    }
    
    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }
    public String toString() {
		return(super.toString()+"   Genre: "+bookGenre);
	}
    
    public static String[]bookCatalogue() throws IOException{
		BufferedReader readFile;
		readFile = new BufferedReader (new FileReader(("/Users/macbookair/Downloads/BookNamesUpdated.csv")) );
		
		for (int index = 0 ; index < books.length ;index++){
			books [index] = readFile.readLine ();
		}
		
		readFile.close();
		
		return books;
	}//readFromFile
    
}

