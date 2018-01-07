package ie.gmit.sw;

import java.util.HashMap;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws Exception {
		DatabaseImpl dbI = new DatabaseImpl();
		dbI.setup();
		dbI.showAllDocs();
		
		// Shingle the text files, method outputs some info (hashcodes, shingles, total shingles etc)
		FileHandler fh = new FileHandler();
		fh.readFile("warandpeace.txt");
		// Output hash table (limited to 5 outputs for the sake of tidiness)
		System.out.println("Example hash table entries: ");
		fh.getHashTable();
		// Query the hash table
		System.out.println("\nQuery example: \n1226392215: " + fh.queryHashTable(-1801141083));
		List<Integer> hc1 = fh.getHashCodes();
		
		
		
		fh.readFile("warandpeacecomp.txt");
		List<Integer> hc2 = fh.getHashCodes();
		
		// Output hash table (limited to 5 outputs for the sake of tidiness)
		System.out.println("Example hash table entries: ");
		fh.getHashTable();
		
		// Query the hash table
		System.out.println("\nQuery example: \n1226392215: " + fh.queryHashTable(-1801141083));
		
		// Compare two documents
		System.out.println("Comparison: ");
		ComparisonImpl c1 = new ComparisonImpl();
		System.out.println(c1.compare(hc1, hc2));
		
	}

}
