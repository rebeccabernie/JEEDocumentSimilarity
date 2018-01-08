package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Need this for handling file stuff
// Specifically reading / shingling / hashing
// ... Hardly need to compare whole document..? Might limit number of shingles, at least for testing

public class FileHandler {
	//private File file; // document for preparing
	private static Map<Integer, String> hashTable = new HashMap<Integer, String>(); // hashmap containing hashtable of info for shingles
	private static List<Integer> hashCodes = new ArrayList<Integer>(); // hashmap containing hashtable of info for shingles

	
	// readFile - will read file, handle splitting into shingles and hashing
	public void readFile(String content) throws Exception {
			
		String shingle = ""; // Shingles will be a string, then converted to hash
		int wordCount = 0; // Keep count of words for shingling
		int shingleCount = 0; // Keep count of total shingles
		
		// Clear anything that might be in the hash table
		if (hashTable.isEmpty() == false){
			hashTable.clear();
		}

		//BufferedReader br = new BufferedReader(new FileReader(filename));
		//System.out.println("Filename: " + filename);
		String line = null;

		if (shingleCount < 2000) { // While the limit hasn't been hit
			// Array of words, split does not include the specified argument (space), adapted from https://stackoverflow.com/a/18831709/7232648
			// Replace gets rid of all non alphabetical characters (punctuation etc)
			// Lower case for the sake of "The / the" etc should be classed as the same word
			String[] words = content.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			
			for (String word : words) { // For each word in the words array
				wordCount++; // Increment count
				if(wordCount < 5) { // If count is less than 5, add the word to the current shingle string
					shingle = shingle.concat(word + " ");
				} else if(wordCount == 5) { // When the shingle reaches 5,
					shingle =  shingle.concat(word); // Add the word and...
					hashTable.put(shingle.hashCode(), shingle); // Add the hash code for the whole shingle, and the shingle itself (as key / value pair) to the hashtable
					shingle = ""; // Reset the shingle string
					wordCount = 0; // Reset the shingle word count
					shingleCount++; // Increment total shingles
				} // end if / else
			} // end for
			
		} // end if
		
		//br.close(); // Close the buffered reader
		
	} // end readFile
	
	// Query hash table using hashCode to get associated string
	public String queryHashTable(int request) {
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
            //hashCodes.add(i);
		} 
		
		return hashTable;
	}
	
	public List<Integer> getHashCodes(Map<Integer, String> ht) {
		
		if (hashCodes.isEmpty() == false){
			hashCodes.clear();
		}
		
		for (Integer i: ht.keySet())
            hashCodes.add(i);
		
		return hashCodes;
	}

}
