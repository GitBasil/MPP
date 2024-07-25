package business;

import java.io.Serializable;

//Thanks for the comment

final public class Author extends Person implements Serializable {
	private String bio;
	public String getBio() {
		//basil
		return bio;
	}
	
	public Author(String f, String l, String t, Address a, String bio) {
		super(f, l, t, a);
		
		this.bio = bio;
	}

	private static final long serialVersionUID = 7508481940058530471L;
}
