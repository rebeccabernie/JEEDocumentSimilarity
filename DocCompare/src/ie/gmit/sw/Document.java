package ie.gmit.sw;

// Just get/set params for a given document

public class Document {
	
	private String name; // Doc name
	private String content; // Contents of doc

	// Using source - generate constructor, get/set 

	// Constructor
	public Document(String name, String content) {
		super();
		this.name = name;
		this.content = content;
		//this.length = length;
	}
	
	// Doc Name ----------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Doc Content -------------------------
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
