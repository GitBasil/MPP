package lesson7.exercise_3a;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ListInfo {
	List<String> list = new ArrayList<>();
	MyStringList strList = new MyStringList();
	public static void main(String[] args) {
		ListInfo li = new ListInfo();
		li.process();
		System.out.println(li.strList);
	}
	
	public void process() {
		list.add("A");
		list.add("W");
		list.add("K");
		list.add("C");
		
		//use java8 foreach to copy all list elements into strList
//		class MyConsumer implements Consumer<String> {
//			public void accept(String s) {
//				strList.add(s);
//			}
//		}
		//list.forEach(new MyConsumer());
		list.forEach(s -> strList.add(s));
		
		
	}
}
