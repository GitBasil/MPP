package prog3_3;

public class MyStringList {
	private final int INITIAL_LENGTH = 2;
	private String[] strArray; 
	private int size;
	
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}
	
	public void add(String s){
		//implement
		//System.out.println(this.strArray.length);
		if(size >= this.strArray.length) {
			resize();			
		}
		this.strArray[size] = s;
		size++;
	}
	
	public String get(int i){
		if(i <= size)
			return strArray[i];
		else
			return "Error Index";
	}
	
	public boolean find(String s){
		for(int i =0;i < this.strArray.length;i++) {
			if(this.strArray[i] == s) {
				return true;
			}
		}
		return false;
	}
	
	public void insert(String s, int pos){
		//implement
		if(pos < this.strArray.length) {
			this.strArray[pos] = s;
		}
	}
	
	public boolean remove(String s) {
		for(int i =0;i < this.strArray.length;i++) {
			if(this.strArray[i] == s) {
				this.strArray[i] = null;
				size--;
				return true;
			}
		}
		return false;
	}
	
	private void resize(){
		//implement
		String[] newStrArray = new String[this.size * this.INITIAL_LENGTH];
		System.arraycopy(this.strArray, 0, newStrArray, 0, this.size);
		this.strArray = newStrArray;
		System.out.println("Resizing...");
	}
	
	public String toString() {
		String str = "";// = String.join(",", this.strArray[size]);
		for(int i = 0;i < this.strArray.length;i++) {
			if(this.strArray[i] != null) {
				if(str != "") {
					str += ",";
				}
				str += this.strArray[i];
			}
		}
        return "["+str+"]";
	}
	public int size() {
		return size;
	}

	public static void main(String[] args){
		MyStringList l = new MyStringList();
		l.add("Bob");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Steve");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Susan");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Mark");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.add("Dave");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.remove("Mark");
		System.out.println("The list of size " + l.size() + " is " + l.toString());
		l.remove("Bob");
		System.out.println("The list of size " + l.size() + " is " + l.toString());	
	}

}