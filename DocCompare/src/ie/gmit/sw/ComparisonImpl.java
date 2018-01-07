package ie.gmit.sw;

import java.util.List;

// Comparison handles anything to do with calculating similarity between docs, implements Comparator interface
// Going by spec, Set sounds like a good collection type to use for now (- size/contains/retainAll, and no duplicates) 
// 

public class ComparisonImpl implements Comparator {
	
	// Do actual comparing stuff here
	// Calculate similarity between docs
	// Need somewhere to store identical shingles - map / array?
	

	public int compare(List<Integer> a, List<Integer> b) {
		// Just getting number of similarities for the moment
		int similarity = 0;
		int size;
		
		if (a.size() < b.size())
			size = a.size();
		else
			size = b.size();
		
		//System.out.println("a: " + a.size());
		//System.out.println("b: " + b.size());

		// Will loop through given lists, i being the index
		for(int i = 0; i < size; i++) {
			if(a.contains(b.get(i))) {
				similarity++; // Add one to the similarity count
			}
		}
		
		//System.out.println(a.size() + " in a.");
		//System.out.println(b.size() + " in b.");
		//System.out.println(size + " shingles compared.");
		
		return similarity;
	}
	
	
	
	

}
