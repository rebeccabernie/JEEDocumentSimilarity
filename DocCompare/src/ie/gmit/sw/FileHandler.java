package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Need this for handling file stuff
// Specifically reading / shingling / hashing
// ... Hardly need to compare whole document..? Might limit number of shingles, at least for testing

public class FileHandler {
	//private File file; // document for preparing
	private Set<Integer> shingles = new HashSet<Integer>();// set of shingles
	private static Map<Integer, String> hashTable = new HashMap<Integer, String>(); // hashmap containing hashtable of info for shingles
	private static List<Integer> hashCodes = new ArrayList<Integer>(); // hashmap containing hashtable of info for shingles

	
	// readFile - will read file, handle splitting into shingles and hashing, will return a set of shingles
	public Set<Integer> readFile(String filename) throws Exception {
			
		String shingle = ""; // Shingles will be a string, then converted to hash
		int wordCount = 0; // Keep count of words for shingling
		int shingleCount = 0; // Keep count of total shingles

		BufferedReader br = new BufferedReader(new FileReader(filename));
		System.out.println("Filename: " + filename);
		String line = null;

		while (shingleCount < 2000 && (line = br.readLine()) != null) { // While the limit hasn't been hit and there's still stuff in the file...
			// Array of words, split does not include the specified argument (space), adapted from https://stackoverflow.com/a/18831709/7232648
			// Replace gets rid of all non alphabetical characters (punctuation etc)
			// Lower case for the sake of "The / the" etc should be classed as the same word
			String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			
			for (String word : words) { // For each word in the words array
				//System.out.println(word);
				wordCount++; // Increment count
				if(wordCount < 5) { // If count is less than 5, add the word to the current shingle string
					shingle = shingle.concat(word + " ");
				} else if(wordCount == 5) { // When the shingle reaches 5,
					shingle =  shingle.concat(word); // Add the word and...
					//System.out.println("Hashcode for " + shingle + ": " + shingle.hashCode()); // for testing
					
					hashTable.put(shingle.hashCode(), shingle); // Add the hash code for the whole shingle, and the shingle itself (as key / value pair) to the hashtable
					shingles.add(shingle.hashCode()); // Add the hash code for the shingle to the set of shingles
					shingle = ""; // Reset the shingle string
					wordCount = 0; // Reset the shingle word count
					shingleCount++; // Increment total shingles
				} // end if / else
			} // end for
			
		} // end while
		
		br.close(); // Close the buffered reader
		System.out.println("Total shingles: " + shingleCount);
		System.out.println(filename + " complete.");
		System.out.println();
		return shingles; // Return shingles set
		
	} // end readFile
	
	// Query hash table using hashCode to get associated string
	public static String queryHashTable(int request) {
		String result = hashTable.get(request);	
		return result;		
	}

	// Displays the hash table
	public Map<Integer, String> getHashTable() {
		int x = 0;
		
		// Loop through hash table and display entries adapted from https://stackoverflow.com/a/5920157
		for (Integer i: hashTable.keySet()){
			x++;
            if (x > 5)
            	break;
            
            String key =i.toString();
            String value = hashTable.get(i).toString();  
            System.out.println(key + " " + value);
            hashCodes.add(i);
		} 
		
		return hashTable;
	}
	
	public List<Integer> getHashCodes() {
		for (Integer i: hashTable.keySet())
            hashCodes.add(i);
		
		return hashCodes;
	}

}
