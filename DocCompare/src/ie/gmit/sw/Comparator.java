package ie.gmit.sw;

import java.util.List;

/**
* <h2>Comparator Interface</h2>
* The Comparator interface defines methods to be used in its implementation.
*
* @author  Rebecca Kane
* @version 1.0
*/

public interface Comparator {
	/**
	* This is the compare method which calculates the similarity of two documents.
   	* @param a			the list of hash codes generated from shingling the first document
   	* @param b			the list of hash codes generated from shingling the second document
   	* @return float		the similarity between a and b as a percentage / 100	
   	*/
	public float compare(List<Integer>a, List<Integer>b); // Pass two lists (a and b) to the compare method

}
