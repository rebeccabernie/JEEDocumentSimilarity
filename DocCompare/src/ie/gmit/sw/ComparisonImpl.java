package ie.gmit.sw;

import java.util.List;

// Comparison handles anything to do with calculating similarity between docs, implements Comparator interface
// Going by spec, Set sounds like a good collection type to use for now (- size/contains/retainAll, and no duplicates) 
// 

public class ComparisonImpl implements Comparator {
	
	// Do actual comparing stuff here
	// Calculate similarity between docs
	// Need somewhere to store identical shingles - map / array?
	

	public float compare(List<Integer> a, List<Integer> b) {
		// Just getting number of similarities for the moment
		int similarity = 0;
		

		for(int i = 0; i < 2000; i++) {
			if(a.contains(b.get(i))) {
				similarity++; // Add one to the similarity count
			}
		}
		
		return similarity;
	}
	
	
	
	

}
