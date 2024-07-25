package lesson7.exercise_1_soln;

import java.util.*;

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
	
	
    /* The implementation of toString has been moved to the interface */
	@Override
	public String toString() {
		return asString();
	}


	
}
