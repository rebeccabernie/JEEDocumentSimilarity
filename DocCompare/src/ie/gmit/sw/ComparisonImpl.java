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
