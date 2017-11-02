import java.util.ArrayList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}
	
	public int findNumberOfBooksInYear(int year) {
		List<Book> booksList = this.dataTier.getAllBooks();
		//int countBooksInYear = 0;
		//for (Book book: booksList) {
			//if (book.getPublicationYear() == year) {
				//countBooksInYear++;
			//}
		//}
		//System.out.println("foreach count "+ countBooksInYear);
		int countStream = (int) booksList.stream().filter(x -> x.getPublicationYear() == year).count();
		System.out.println("Stream count " + countStream);
		return countStream;
	}
	
	public ArrayList<String>  findBookTitlesByAuthor(String authorName){
		ArrayList<String> listOfTitles = new ArrayList<>();
		System.out.println("look for " + authorName);
		//*
		  for (Book book:  this.dataTier.getAllBooks()) {
			  System.out.println("Compare " + book.getAuthor() +" to " + authorName.replaceAll("\"", "").toLowerCase());
			if (book.getAuthor().toLowerCase().equals(authorName.replaceAll("\"", "").toLowerCase())|| book.getAuthor().toLowerCase().contains(authorName.replaceAll("\"", "").toLowerCase()) ){
				System.out.println("add" + book.getAuthor());
				listOfTitles.add(book.getTitle());
			}
		}//*/
		//this.dataTier.getAllBooks().stream().filter(x -> x.getAuthor().toLowerCase() == authorName.toLowerCase()).forEach(x-> listOfTitles.add(x.getAuthor()));
		  System.out.println(listOfTitles.size());
		return listOfTitles;
	}
}
