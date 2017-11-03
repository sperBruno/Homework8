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

		int userOption = 0;
		do {
			System.out.println("Choose a method");
			System.out.println("1. Show Number Of Books In Year");
			System.out.println("2. Show Book Titles By Author");
			System.out.println("Enter the number option:");
			userOption = scanner.nextInt();
		} while (userOption <= 0 || userOption > 2);
		switch (userOption) {
		case 1:
			showNumberOfBooksInYear();
			break;
		case 2:
			showBookTitlesByAuthor();
			break;
		default:
			break;
		}

	}

	public void showNumberOfBooksInYear() {
		int year = 0;
		do {
			System.out.println("Enter a year:");
			year = scanner.nextInt();
		} while (year == 0);

		System.out.println(this.logicTier.findNumberOfBooksInYear(year));

	}

	public void showBookTitlesByAuthor() {
		String authorName = "";
		do {
			System.out.println("Enter author name:");
			authorName = scanner.nextLine();
		} while (authorName.length() == 0);

		this.logicTier.findBookTitlesByAuthor(authorName).stream().forEach(System.out::println);
	}

}
