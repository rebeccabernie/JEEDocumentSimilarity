package ie.gmit.sw;

import java.util.List;

/**
* <h2>Comparison Implementation</h2>
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
	* The compare method calculates the similarity of two documents.&nsbp;It takes two lists of Integers as parameters and loops through the first list one element at a time to find any instances of the same element in the second list.&nsbp;It divides the total number of similarities by the total number of iterations of the loop and returns the result of this calculation as a percentage out of 100 - <i>i.e.&nsbp;3.9 = 3.9%, 42 = 42%, 100 = 100% etc.</i>
	* <p>
	* <b>Note:</b> Number of iterations of the loop is determined using the smaller of the two lists, preventing "out of bounds" errors.
	* 
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
