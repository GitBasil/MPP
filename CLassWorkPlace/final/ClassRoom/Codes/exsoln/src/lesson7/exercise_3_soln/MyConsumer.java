package lesson7.exercise_3_soln;

import java.util.function.Consumer;


public class MyConsumer implements Consumer<String> {
	private MyStringList list;
	public MyConsumer(MyStringList list) {
		this.list = list;
	}
	@Override
	public void accept(String item) {
		list.add(item);	
	}
}
