package ie.gmit.sw;

public class Runner {

	public static void main(String[] args) throws Exception {
		DatabaseImpl dbI = new DatabaseImpl();
		dbI.setup();
		dbI.showAllDocs();
		
		FileHandler fh = new FileHandler();
		fh.readFile("warandpeace.txt");
		fh.readFile("test1.txt");

	}

}
