import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}
	
	public List<Book> getAllBooks(){
		List<Book> listOfBooks = new ArrayList<Book>();
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(this.fileName);
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String[] lines = sCurrentLine.replaceAll("	", "  ").split("  ");
				//System.out.println(lines.length);
				for (String element: lines) {
					
					if( element.contains("  ")){
						System.out.println("Skipping due to spacess");
						continue;
					}
					//System.out.println(element);
					
				}
				if(lines.length == 3) {
					String bookName = lines[0].replaceAll("\"", "").replaceAll("#", "");
					String authorName = lines[1].replaceAll("\"", "");
					int year = Integer.parseInt(lines[2]);
					listOfBooks.add(new Book(bookName, authorName, year));
				}
				//System.out.println(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

		/*System.out.println(listOfBooks.size());
		for(Book book: listOfBooks){
			System.out.println(book);;
		}*/
		return listOfBooks;
	}
}
