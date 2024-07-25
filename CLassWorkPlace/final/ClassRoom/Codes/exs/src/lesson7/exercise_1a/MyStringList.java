package lesson7.exercise_1a;

/**
 * This class represents a array-list of Strings.
 * It implements the interface StringList, which
 * lists the main operations that need to be supported.
 * 
 * Using Java 8 interfaces, the effort to implement
 * the StringList interface is greatly reduced.
 *
 */
public class MyStringList implements StringList {
	private static final int INITIAL_SIZE = 100;
	private String[] strArray;
	private int size;
	
	/* constructor */
	public MyStringList() {
		strArray = new String[INITIAL_SIZE];
		size = 0;
	}
	
	//implementations of interface methods
	@Override
	public String[] strArray() {
		return strArray;
	}
	@Override
	public void incrementSize() {
		size++;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	/////// Can we make life easier by implementing these methods 
	/////// in a Java 8 interface? 
//	@Override
//	public void add(String s) {
//		strArray[size] = s;
//		incrementSize();
//	}
//	@Override
//	public String get(int i) {
//		if (i < 0 || i >= size) {
//			return null;
//		}
//		return strArray[i];
//	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size - 1; ++i) {
			sb.append(strArray[i] + ", ");
		}
		if(size > 0)
		   sb.append(strArray[size - 1] + "]");
		return sb.toString();
	}


	
}
