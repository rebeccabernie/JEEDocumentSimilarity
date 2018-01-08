package ie.gmit.sw;

/**
* <h2>Database Implementation</h2>
* The Database implementation implements the Database interface and initialises the db4o database. 
*
* @author  Rebecca Kane
* @version 1.0
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentActivationSupport;
import com.db4o.ta.TransparentPersistenceSupport;

import xtea_db4o.XTEA;
import xtea_db4o.XTeaEncryptionStorage;

// Implementation of database: inherits methods from interface, does actual DB operations

public class DatabaseImpl implements Database {
	private ObjectContainer db = null;
	
	// Set up DB, adapted from Object Persistence in-class exercise
	/**
	* The setup method initialises the database and configures it for storing/retrieving objects.
   	*/
	@Override
	public void setup() {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().add(new TransparentActivationSupport()); //Real lazy. Saves all the config commented out below
		config.common().add(new TransparentPersistenceSupport()); //Lazier still. Saves all the config commented out below
		config.common().updateDepth(7); //Propagate updates
		
		// Basic Db4O only has caesar cypher encryption, use xtea for encryption instead
		config.file().storage(new XTeaEncryptionStorage("password", XTEA.ITERATIONS64));

		//Open a local database. Use Db4o.openServer(config, server, port) for full client / server
		db = Db4oEmbedded.openFile(config, "docs.data");
		ObjectSet<Document> docs = db.query(Document.class);
		if (docs.isEmpty() == true){ // Only add if db is empty, prevents duplicates
			try { // Read file into string adapted from http://javarevisited.blogspot.ie/2015/09/how-to-read-file-into-string-in-java-7.html
				
				// Convert W+P txt file into a string, create a new Document object for it, add it to database
				String warandpeace = new String(Files.readAllBytes(Paths.get("warandpeace.txt")));
				Document doc1 = new Document("War and Peace", warandpeace);
				db.store(doc1);
				
				// Convert DBG txt file into a string, create a new Document object for it, add it to database
				String comparisonfile = new String(Files.readAllBytes(Paths.get("comparisonfile.txt")));
				Document doc2 = new Document("Test File \t", comparisonfile);
				db.store(doc2);
				
				db.commit(); // Commits the transaction
				
			} catch (IOException e) {
				System.out.println("File not found...");
				e.printStackTrace();
			}
		
		}
	}
	
	public List<String> getAllDocs(){
		//An ObjectSet is a specialised List for storing results
		ObjectSet<Document> docs = db.query(Document.class);
		List<String> contents = new ArrayList<String>();
		for (Document doc : docs) {
			System.out.println("[Document] " + doc.getName() + "\t Database ObjID: " + db.ext().getID(doc));
			contents.add(doc.getContent());
			db.commit();
		}
		return contents;
	}

}
