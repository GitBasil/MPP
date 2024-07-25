package lesson7.exercise_1_soln;

public interface StringList {
	
	//unimplemented operations
	String[] strArray();
	int size();
	void incrementSize();

	//// Java 8 interface technique for 
	//// implementing more interface operations
	//// directly in the interface
	 
	/** Adds a string to the end of the list */
	default public void add(String s) {	
		strArray()[size()] = s;
		incrementSize();
		
	}
	
	/** Gets the i_th string in the list */
	default public String get(int i) {
		if (i < 0 || i >= size()) {
			return null;
		}
		return strArray()[i];
	}
	
	/** Most of the toString method for MyStringList is now here
	 *  in the interface.
	 */
	default public String asString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size() - 1; ++i) {
			sb.append(strArray()[i] + ", ");
		}
		if(size() > 0)
		   sb.append(strArray()[size() - 1] + "]");
		return sb.toString();
	}
	
}
