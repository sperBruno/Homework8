/*
 * SD2x Homework #8
 * This class creates the classes in the three tiers and links them together.
 * You should not modify this code. You do not need to submit it.
 */

public class Main {
	
	public static void main(String[] args) {
		
		DataTier dt = new DataTier("C:/repositories/java/homework8/books2.txt");
		dt.getAllBooks();
		LogicTier lt = new LogicTier(dt);
		lt.findBookTitlesByAuthor("\"Brown, Dan\"");
		PresentationTier pt = new PresentationTier(lt);
		pt.start();
		
	}

}
