package prog6_1_soln;

public class MyTable {
	private Entry[] entries = new Entry[26];
	private char[] a = new char[]{'a','b','c'};
	private int size = 0;
	//returns the String that is matched with char c in the table
	public String get(char c){
		for (int i = 0; i < a.length; i++) {
			if (a[i] == c) {
				return entries[i].toString();
			}
		}
		return "error index";
	}
	//adds to the table a pair (c, s) so that s can be looked up using c 
	public void add(char c, String s) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == c) {
				size++;
				entries[i] = new Entry(s, c);
				break;
			}
		}
	}
	//returns a String consisting of nicely formatted display
	//of the contents of the table
	@Override
	public String toString() {
		String output = "";
		for(int i=0;i<size;i++) {
			output += entries[i].toString()+"\n";
		}
		return output;
	}
	
	private class Entry {
		private String str;
		private char ch;
		Entry(String str, char ch){
			this.ch = ch;
			this.str = str;
		}
		//returns a String of the form "ch->str" 
		@Override
		public String toString() {
			return this.ch+"->"+this.str;
		}
	}

}