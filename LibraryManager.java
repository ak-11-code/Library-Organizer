import java.util.*;
import java.io.*;
public class LibraryManager {
	static Scanner input = new Scanner (System.in);
	static String[]bookList = Book.books;
	static String[]magazineArray = Magazine.magazines;
	static int available = 0;
	static GreetingConclusion greetingConclusion;
	
	public static void main(String[] args)throws IOException {
		//Call read file methods
		Book.bookCatalogue();
		Magazine.magazineCatalogue();
		greetingConclusion = new GreetingConclusion();
		
		System.out.println(greetingConclusion.getGreetingMessage());
		
		String userContinue = "yes";
		while(userContinue.equalsIgnoreCase("yes")) {
			
			//Ask user what action they wish to take 
			//Get input of type int
			System.out.println("\nWhat would you like to do? Enter the number.\n");
			System.out.println("\n1. Add a book\n");
			System.out.println("\n2. Add a magazine\n");
			System.out.println("\n3. Search for a book/magazine\n");
			System.out.println("\n4. Sort by title\n");
			System.out.println("\n5. Save and exit\n");
			
			int userChoice = input.nextInt();
			input.nextLine();
			
			//Get number of books wished to be added
			//Add that many books to the list
			if(userChoice == 1) {
				System.out.println("\nHow many books would you like to add?\n");
				int addBookNum = input.nextInt();
				input.nextLine(); // Consume newline
				
				for(int i=0; i<addBookNum; i++) {
					addABook();
					
				}//for
				
			}//If user adds a book
			
			//Get number of Magazines wished to be added
			//Add that many Magazines to the list
			else if(userChoice == 2) {
				System.out.println("\nHow many Magazines would you like to add?\n");
				int addMagazineNum = input.nextInt();
				input.nextLine(); // Consume newline
				
				for(int i=0; i<addMagazineNum; i++) {
					addAMagazine();
					
				}//for
				
			}//If user adds a magazine
			
			//Search for a book/magazine and finds its location
			else if(userChoice == 3) {
				BookOrMagazineSearch();//call method
				
			}//User wants to search for a book/magazine
				
			//Sort the list of books/magazines
			else if(userChoice == 4) {
				BookOrMagazineSort();//call method
				
			}
			
			//exit loop
			else {
				userContinue ="no";
			}
		}//while
		
		System.out.println(greetingConclusion.getConclusionMessage());
		
	}
	
	//Parameter is a string array to be printed
	public static void printArrayElements(String[] strArray) {
		for (int i = 0; i< strArray.length; i++) {
			System.out.println(strArray[i]);
		}//for
	}//printArrayElements
	
	//Has oneD string array parameter that sorts it using bubble sort
	public static String[] bubbleSortString(String[]array) {
		String temp;
		for (int index1 = 0; index1<array.length;index1++){
			for(int index2 = 1;index2<array.length; index2++) {
				temp = array[index2-1];
				if(array[index2].compareToIgnoreCase(array[index2-1])<0 ){//checks all previous values beside each other after assuming start is in right position
					array[index2-1] = array[index2];
					array[index2]  = temp;
				}//if
			}//for index 2
				
		}//for index 1
		return array;
	}//bubbleSortString
	
	//Uses string array parameter and has an string searchValue parameter
		public static int spaceAvailability(String[] array) {
			//used if no item in the array is called "Empty"
			int location = -1;
					
			//find the location of the book in the list
			for(int i=0; i<array.length; i++) {
				if(array[i].equalsIgnoreCase("empty")) {
					location = i;
					break;
							
				}//if
						
			}//for
					
			return location;
		}//spaceAvailability
		
		//Adds book to array
		public static void addABook() throws IOException{
			
			Book.bookCatalogue();
			
			available = spaceAvailability(Book.books);
			
			if(available==-1) {
				System.out.println("\nNo Space Available\n");
			}
			
			else {
				System.out.println("\nPlease enter the name of the book\n");
				String name = input.nextLine();
				Book.books[available] = name;
				
			}
			
			printArrayElements(Book.books);
			
		}//addABook
		
		//Adds magazine to array
		public static void addAMagazine()throws IOException{
			Magazine.magazineCatalogue();
			
			int availableSpace = spaceAvailability(Magazine.magazines);
			
			if(availableSpace==-1) {
				System.out.println("\nNo Space Available\n");
			}
			
			else {
				System.out.println("\nPlease enter the name of the magazine\n");
				String name = input.nextLine();
				Magazine.magazines[availableSpace] = name;
			}
			
			printArrayElements(Magazine.magazines);
		}//addAMagazine
		
		//Follows the sequential sort
		//Uses String array parameter and has an string searchValue parameter
		//Uses recursion
		public static int searchItem(String[] array, String searchValue) {
	        return searchItemHelper(array, searchValue, 0);
	    }//searchItem
		
		//Used in searchItem to follow recusion
		//Has string array, string search value, and integer index value paramters
		private static int searchItemHelper(String[] array, String searchValue, int index) {
	        if (index >= array.length) {
	        	return -1;
	        }
	        if (array[index] != null && array[index].equalsIgnoreCase(searchValue)) {
	        	return index;
	        }
	        
	        return searchItemHelper(array, searchValue, index + 1);
	    }//searchItemHelper
		//Search for a book or magazine
		public static void BookOrMagazineSearch() {
			System.out.println("\nWould you like to search for a book or magazine?\n");
			String searchBookOrMag = input.next();
			input.nextLine(); // Consume newline
			
			if(searchBookOrMag.equalsIgnoreCase("book")) {
				System.out.println("\nEnter the book title\n");
				String bookSearch = input.next();
				
				int bookOrder = searchItem(Book.books, bookSearch);
				if(bookOrder == -1) {
					System.out.println("\nBook not found\n");
				}
				
				else {
					System.out.println("\nThe book "+bookSearch+" is the "
				+(bookOrder+1)
				+" book in the library\n");
				}
			}//book search
			
			else {
				System.out.println("\nEnter the magazine title\n");
				String magazineSearch = input.next();
				int magazineOrder = searchItem(Magazine.magazines, magazineSearch);
				if(magazineOrder == -1) {
					System.out.println("\nMagazine not found\n");
				}
				
				else {
					System.out.println("\nThe magazine "+magazineSearch+" is the "
				+(magazineOrder+1)
				+" magazine in the library\n");
				}
			}//magazine search
		}//BookOrMagazineSearch
		
		//Sort the book or magazine array
		public static void BookOrMagazineSort() {
			System.out.println("\nWould you like to sort books or magazines?\n");
			String sortBookOrMagazine = input.next();
			input.nextLine(); // Consume newline
			
			if(sortBookOrMagazine.equalsIgnoreCase("books")) {
				printArrayElements(bubbleSortString(Book.books));
			}
			
			else {
				printArrayElements(bubbleSortString(Magazine.magazines));
			}
			
		}//BookOrMagazineSort
		
}//LibraryManager

