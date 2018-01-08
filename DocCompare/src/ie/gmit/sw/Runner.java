package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Runner {

	public static void main(String[] args) throws Exception {
		DatabaseImpl dbI = new DatabaseImpl();
		dbI.setup();
		List<String> contents = dbI.getAllDocs();
		String warandpeace = contents.get(0);
		String comparisonfile = contents.get(1);
		
		
		// Shingle the text files, method outputs some info (hashcodes, shingles, total shingles etc)
		FileHandler fh = new FileHandler();
		

		fh.readFile(warandpeace);
		System.out.println("\nExample hash table entries: ");
		Map<Integer, String> ht1 = fh.getHashTable(); // Output hash table (limited to 5 outputs for the sake of tidiness)
		System.out.println("\nQuery example: \n-322900793: " + fh.queryHashTable(-322900793)); // Query the hash table
		List<Integer> hc1 = new ArrayList<Integer>(fh.getHashCodes(ht1));
		//System.out.println(hc1.size() + " codes in hc1.\n");
		
		System.out.println("\n\n-- End first doc --\n");
		
		fh.readFile(comparisonfile);
		System.out.println("\nExample hash table entries: ");
		Map<Integer, String> ht2 = fh.getHashTable(); // Output hash table 
		System.out.println("\nQuery example: \n1854958001: " + fh.queryHashTable(1854958001)); // Query the hash table
		List<Integer> hc2 = new ArrayList<Integer>(fh.getHashCodes(ht2));
		//System.out.println(hc2.size() + " codes in hc2.\n");
		
		// Compare two documents
		System.out.println("\nComparison: ");
		ComparisonImpl c1 = new ComparisonImpl();
		System.out.println("file a: " + hc1.size() + " shingles, file b: " + hc2.size() + " shingles");
		//c1.compare(hc1, hc2);
		System.out.println(c1.compare(hc1, hc2) + "% similarity in documents.");
		System.out.println();
		
	}

}
