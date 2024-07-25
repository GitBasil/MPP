package pencil7;
/**
 * StackOverflowError 
 * Why? 
 * because no any condition to stop loop 
 * for example if s.length()==1 return s;
 * */
public class MyClass2 {
	public static void main(String[] args) {
		new MyClass();
	}
	MyClass2() {
		recurse("Hello");
	}
	String recurse(String s){
		if(s==null || s.equals("")) return "";
		int n = s.length();
		String t = s;//permute(s); //rearrange characters of s
		return recurse(t);
	}
}
