package ie.gmit.sw;

public class Runner {

	public static void main(String[] args) {
		DatabaseImpl dbI = new DatabaseImpl();
		dbI.setup();
		dbI.showAllDocs();

	}

}
