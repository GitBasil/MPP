package pencil7;
/**
 * StackOverflowError 
 * Why? 
 * because no any condition to stop loop 
 * for example if s.length()==1 return s;
 * */
class MyClass {
	public static void main(String[] args) {
		new MyClass();
	}
	MyClass() {
		recurse("Hello");
	}
	String recurse(String s){
		if(s==null) return null;
		int r = 10;//RandomNumbers.getRandomInt();
		int n = s.length();
		if(r % 2 == 0)
			return recurse(s.substring(0,n/2));
		else {
			return recurse(s.substring(n/2,n));
		}
	}
}