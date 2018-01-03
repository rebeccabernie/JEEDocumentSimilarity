package ie.gmit.sw;

// Just get/set params for a given document

public class Document {
	
	private String name; // Doc name
	private String content; // Contents of doc
	private int length; // Length of doc (words), might not need

	// Using source - generate constructor, get/set 

	// Constructor
	public Document(String name, String content, int length) {
		super();
		this.name = name;
		this.content = content;
		this.length = length;
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
	
	// Doc Length --------------------------
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	

}
