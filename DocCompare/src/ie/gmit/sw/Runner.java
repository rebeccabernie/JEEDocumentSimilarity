package ie.gmit.sw;

import java.util.HashMap;

public class Runner {

	public static void main(String[] args) throws Exception {
		DatabaseImpl dbI = new DatabaseImpl();
		dbI.setup();
		dbI.showAllDocs();
		
		FileHandler fh = new FileHandler();
		fh.readFile("warandpeace.txt");
		fh.readFile("test1.txt");
		
		String hm = fh.queryHashTable(1226392215);
		System.out.println("1226392215: " + hm);
		
		System.out.println("Hashtable: ");
		fh.getHashTable();
		
	}

}
