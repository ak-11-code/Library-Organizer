import java.io.*;
public class Magazine extends Library{
	private int issueNumber;
	static String[]magazines = new String[20];
	
	//Constructor for Magazine if called with parameters
    public Magazine(String bookTitle, String authorName, int bookYear, int issueNumber) {
        super(bookTitle, authorName, bookYear);
        this.issueNumber = issueNumber;
    }
    
	//Constructor for Magazine if called without parameters
    public Magazine() {
    	super();
    	issueNumber = 0;
    }
    
    public int getIssueNumber() {
        return issueNumber;
    }
    
    public void setIssueNumber(int issueNumber) {
    	this.issueNumber = issueNumber;
    }
    
    
    public String toString() {
		return(super.toString()+" Issue Number: "+issueNumber);
	}
    
    public static String[]magazineCatalogue() throws IOException{
		
   	BufferedReader readFile;
		readFile = new BufferedReader (new FileReader(("/Users/macbookair/Desktop/School/Grade 12/Computer Science - 12/MagList.txt")) );
		
		for (int index = 0 ; index < magazines.length ;index++){
			magazines[index] = readFile.readLine ();
		}
		
		readFile.close();
		
		return magazines;
	}//readFromFile
    
}//Magazine
