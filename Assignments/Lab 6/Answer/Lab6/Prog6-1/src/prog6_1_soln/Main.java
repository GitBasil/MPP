package prog6_1_soln;

public class Main {

	public static void main(String[] args) {
		MyTable t = new MyTable();
		t.add('a', "Andrew");
		t.add('b',"Billy");
		t.add('c',"Charlie");
		String s = t.get('c');
		System.out.println("ALL Items: \n"+t);
		System.out.println("\n GET Index 'c': "+s);
	}

}
