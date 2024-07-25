package lesson7.exercise_1_advanced_soln;

public interface StringList {
	abstract String[] strArray();
	abstract int size();
	abstract void setSize(int val);
	abstract void resize();
	abstract void overwrite(String val, int pos);
	abstract boolean copy(int pos1, int pos2);
	
	
	/** Adds a string to the end of the list */
	default public void add(String s) {	
		if (size() == strArray().length)
			resize();
		strArray()[size()] = s;
		setSize(size() + 1);
		
	}
	
	/** Gets the i_th string in the list */
	default public String get(int i) {
		if (i < 0 || i >= size()) {
			return null;
		}
		return strArray()[i];
	}

	/** Returns true of String s is found in the list, false otherwise */
	default public boolean find(String s) {	
		for (String test : strArray()) {
			if (test.equals(s))
				return true;
		}
		return false;
	}

	/** Inserts String s into position pos, moving elements to the right as needed */
	default public void insert(String s, int pos) {
		if (pos > size())
			return;
		if (pos >= strArray().length || size() + 1 > strArray().length) {
			resize();
		}
		String[] temp = new String[strArray().length + 1];
		System.arraycopy(strArray(), 0, temp, 0, pos);
		temp[pos] = s;

		System.arraycopy(strArray(), pos, temp, pos + 1, strArray().length - pos);
		setSize(size() + 1);
		for(int i = 0; i < size(); ++i ) {
			overwrite(temp[i], i);
		}

	}


	/** Removes first occurrence of s if found and returns true; if not found, returns false */
	default public boolean remove(String s) {
		if (size() == 0)
			return false;
		int index = -1;
		for (int i = 0; i < size(); ++i) {
			if (strArray()[i].equals(s)) {
				index = i;
				break;
			}
		}
		if (index == -1)
			return false;
		String[] temp = new String[strArray().length];
		System.arraycopy(strArray(), 0, temp, 0, index);
		System.arraycopy(strArray(), index + 1, temp, index, strArray().length
				- (index + 1));
		setSize(size() - 1);
		for(int i = 0; i < size(); ++i ) {
			overwrite(temp[i], i);
		}
		return true;
	}
	
	// static sort method
	public static MyStringList sort(MyStringList list) {
		InsertionSort isort = new InsertionSort();
		MyStringList sorted = isort.sort(list);
	
		return sorted;	
	}
	
}
