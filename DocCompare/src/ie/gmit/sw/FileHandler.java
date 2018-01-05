package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Set;

// Need this for handling file stuff
// Specifically reading / shingling / hashing
// ... Hardly need to compare whole document..? Might limit number of shingles, at least for testing

public class FileHandler {
	
	//private File file; // document for preparing
	private Set<Integer> shingles; // set of shingles
	//private static HashMap<Integer, String> hashTable; // hashmap containing hashtable of info for shingles

	// readFile - will read file, handle splitting into shingles and hashing, will return a set of shingles
	public Set<Integer> readFile(String filename) throws Exception {
		String shingle = ""; // Shingles will be a string, then converted to hash

		BufferedReader br = new BufferedReader(new FileReader(filename));
		System.out.println("Filename: " + filename);
		String line = null;

		while ((line = br.readLine()) != null) {
			// Array of words, split does not include the specified argument (space), adapted from https://stackoverflow.com/a/18831709/7232648
			// Replace gets rid of all non alphabetical characters (punctuation etc)
			// Lower case for the sake of "The / the" etc should be classed as the same word
			String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
			int i = 0; // Keep count of words for shingling
			
			for (String word : words) { // For each word in the words array
				i++; // Increment count
				if(i != 5) { // If count is less than 5, add the word to the current shingle string
					shingle += word + " ";
				} else if(i == 5) { // When the shingle reaches 5,
					shingle += word; // Add the word and...
					// Add the hash code for the whole shingle, and the shingle itself (as key / value pair) to the hashtable
					//hashTable.put(shingle.hashCode(), shingle);
					// Add the hash code for the shingle to the set of shingles
					shingles.add(shingle.hashCode());
					shingle = ""; // Reset the shingle string
					i = 0; // Reset the shingle word count
				} // end if / else
			} // end for
		} // end while
		
		br.close(); // Close the buffered reader
		System.out.println("Shingling complete.");
		return shingles; // Return shingles set
		
	} // end readFile

}
