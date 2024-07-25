package lesson7.exercise_3_soln;

import java.util.*;
import java.util.function.Consumer;

public class ListInfo {
	List<String> list = new ArrayList<>();
	MyStringList strList = new MyStringList();
	public static void main(String[] args) {
		ListInfo li = new ListInfo();
		li.process();
	}
	
	public void process() {
		list.add("A");
		list.add("W");
		list.add("K");
		list.add("C");
		//use java8 foreach to copy all list elements into strList
		MyConsumer c = new MyConsumer(strList);
		list.forEach(c);
		System.out.println(strList);
		list.forEach(new Consumer<String>() {

			public void accept(String t) {
				strList.add(t);
			}
		});
		System.out.println(strList);
	}
	
	//Notice that it is easier to implement Consumer as a nested class
//	class MyConsumer implements Consumer<String> {
//
//		public void accept(String t) {
//			strList.add(t);
//		}
//	}

}
