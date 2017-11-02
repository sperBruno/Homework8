import java.util.Scanner;

/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	private Scanner scanner = new Scanner(System.in);
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void start() {
		
		/* IMPLEMENT THIS METHOD */
		showNumberOfBooksInYear();
		
		showBookTitlesByAuthor();
	}
	
	public void showNumberOfBooksInYear() {
		int year = 0;
		do{ 
			System.out.println("Enter a year:");
			year = scanner.nextInt();
		}while(year==0);
		
		System.out.println(this.logicTier.findNumberOfBooksInYear(year));
		
	}
	
	public void showBookTitlesByAuthor(){
		String authorName = "";
		do{ 
			System.out.println("Enter author name:");
			authorName = scanner.nextLine();
		}while(authorName.length()==0);
		
		this.logicTier.findBookTitlesByAuthor(authorName).stream().forEach(System.out::println);;
	}

}
