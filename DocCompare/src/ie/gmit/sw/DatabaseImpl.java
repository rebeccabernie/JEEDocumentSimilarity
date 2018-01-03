package ie.gmit.sw;

import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentActivationSupport;
import com.db4o.ta.TransparentPersistenceSupport;

import xtea_db4o.XTEA;
import xtea_db4o.XTeaEncryptionStorage;

// Implementation of database: inherits methods from interface, does actual DB operations

public class DatabaseImpl implements Database {
	private ObjectContainer db = null;
	private List<Document> docs = new ArrayList<Document>();
	
	// Set up DB, adapted from Object Persistence in-class exercise
	@Override
	public void setup() {
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().add(new TransparentActivationSupport()); //Real lazy. Saves all the config commented out below
		config.common().add(new TransparentPersistenceSupport()); //Lazier still. Saves all the config commented out below
		config.common().updateDepth(7); //Propagate updates
		
		// Basic Db4O only has caesar cypher encryption, use xtea for encryption instead
		config.file().storage(new XTeaEncryptionStorage("password", XTEA.ITERATIONS64));
		
		/*
		config.common().objectClass(Patient.class).cascadeOnUpdate(true);
		config.common().objectClass(Patient.class).cascadeOnActivate(true);
		config.common().objectClass(MDTReview.class).cascadeOnUpdate(true);
		config.common().objectClass(MDTReview.class).cascadeOnActivate(true);
		config.common().objectClass(User.class).cascadeOnUpdate(true);
		config.common().objectClass(HospitalList.class).cascadeOnUpdate(true);
		config.common().objectClass(TumourSet.class).cascadeOnUpdate(true);
		config.common().objectClass(GPLetter.class).cascadeOnUpdate(true);
		*/

		//Open a local database. Use Db4o.openServer(config, server, port) for full client / server
		db = Db4oEmbedded.openFile(config, "docs.data");
		
	}

	// Compare docs?

	

}
