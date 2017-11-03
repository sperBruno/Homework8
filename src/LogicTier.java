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
		if (year <= 0) {
			System.out.println("Returning 0 because year input is less or equals to 0");
			return 0;
		}
		// int countBooksInYear = 0;
		// for (Book book: booksList) {
		// if (book.getPublicationYear() == year) {
		// countBooksInYear++;
		// }
		// }
		// System.out.println("foreach count "+ countBooksInYear);
		int countStream = (int) booksList.stream().filter(x -> x.getPublicationYear() == year).count();
		//System.out.println("Stream count " + countStream);
		return countStream;
	}

	public ArrayList<String> findBookTitlesByAuthor(String authorName) {
		ArrayList<String> listOfTitles = new ArrayList<>();
		if (authorName.equals(null) || authorName.isEmpty()) {
			return listOfTitles;
		}
		/*
		 * if (!authorName.equals(null)){
		 * 
		 * String authorNameToLowerCase = authorName.replaceAll("\"",
		 * "").toLowerCase(); for (Book book: this.dataTier.getAllBooks()) {
		 * final String currentAuthorToLowerCase =
		 * book.getAuthor().toLowerCase(); if
		 * (currentAuthorToLowerCase.equals(authorNameToLowerCase)||
		 * currentAuthorToLowerCase.contains(authorNameToLowerCase) ){
		 * System.out.println("add" + book.getAuthor());
		 * listOfTitles.add(book.getTitle()); } } }
		 */
		// *
		String authorNameToLowerCase = authorName.replaceAll("\"", "").toLowerCase();
		this.dataTier.getAllBooks().stream()
				.filter(x -> x.getAuthor().toLowerCase().equals(authorNameToLowerCase)
						|| x.getAuthor().toLowerCase().contains(authorNameToLowerCase))
				.forEach(x -> listOfTitles.add(x.getTitle()));
		// */
		return listOfTitles;
	}
}
