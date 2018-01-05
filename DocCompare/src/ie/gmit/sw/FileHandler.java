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
	
	// Will need method for reading file, will return a set of shingles
	// Will also handle adding stuff to hashtable
	
	private File file; // document for preparing
	private Set<Integer> shingles; // set of shingles
	private static HashMap<Integer, String> hashTable; // hashmap containing hashtable of info for shingles
	
	// readFile - will read file, handle splitting into shingles and hashing, will return a set of shingles
	public Set<Integer> readFile() throws Exception {
		String shingle = ""; // Shingles will be a string, then converted to hash

		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = br.readLine()) != null) { 		
			
		}			
			
		return null; // will return shingles set
	}

}
