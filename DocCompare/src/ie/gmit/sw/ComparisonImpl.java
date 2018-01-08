package ie.gmit.sw;

import java.util.List;

/**
* <h1>Comparison Implementation</h1>
* The Comparison implementation implements the Comparator interface and compares the similarity between two given lists. 
*
* @author  Rebecca Kane
* @version 1.0
*/

// Comparison handles anything to do with calculating similarity between docs, implements Comparator interface
// Going by spec, Set sounds like a good collection type to use for now (- size/contains/retainAll, and no duplicates) 

public class ComparisonImpl implements Comparator {
	
	// Do actual comparing stuff here
	// Calculate similarity between docs
	
	/**
	* This is the compare method which calculates the similarity of two documents.&nsbp;It takes two lists of Integers as parameters, performs calculations to determine the similarity of the two lists, and returns the result of these calculations as a percentage out of 100 - <i>i.e. 3.9 = 3.9%, 42 = 42%, 100 = 100% etc.</i>
   	* @param a			the list of hash codes generated from shingling the first document
   	* @param b			the list of hash codes generated from shingling the second document
   	* @return float		the similarity between a and b as a percentage / 100	
   	*/
	public float compare(List<Integer> a, List<Integer> b) {
		int size;
		int similarities = 0;
		float percentage = 0.2f;
		
		if (a.size() < b.size())
			size = a.size();
		else
			size = b.size();

		// Will loop through given lists, i being the index
		for(int i = 0; i < size; i++) {
			if(a.contains(b.get(i))) { // If a has a shingle that also appears somewhere in b
				similarities++; // Add one to the similarity count
			}
		}
		
		System.out.println(size + " shingles compared.");
		System.out.println(similarities + " similar shingles.");
		percentage = ((float)similarities / (float)size) * 100;
		//System.out.println(percentage);
		
		return percentage;
	}

}
