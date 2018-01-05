package ie.gmit.sw;

import java.util.Set;

// Comparison handles anything to do with calculating similarity between docs, implements Comparator interface
// Going by spec, Set sounds like a good collection type to use for now (- size/contains/retainAll, and no duplicates) 
// 

public class ComparisonImpl implements Comparator {
	
	// Do actual comparing stuff here
	// Calculate similarity between docs
	// Need somewhere to store identical shingles - map / array?

	public float compare(Set<Integer> a, Set<Integer> b) {
		float similarity = 0;
		
		return 0; // will return similarity
	}
	
	
	
	

}
