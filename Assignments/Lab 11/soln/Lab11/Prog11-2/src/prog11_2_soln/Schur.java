package prog11_2_soln;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Schur {
	public boolean checkForSum(List<Integer> list, Integer z) {
		HashMap<Integer, Integer> alreadyChecked = new HashMap<Integer, Integer>();
		Integer next = 0;
		Integer x = 0;
		for(int i = 0; i < list.size(); ++i) {
			next = list.get(i);
			if(!alreadyChecked.containsKey(next)) {
				if((x+next)==z) {
					return true;
				} else {
					x = next;
				}
				alreadyChecked.put(next, next);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Schur s = new Schur();
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(5);
		System.out.println("Sum is 10: "+s.checkForSum(list, 10));
		System.out.println("Sum is 11: "+s.checkForSum(list, 11));
		System.out.println("Sum is 9: "+s.checkForSum(list, 9));
		System.out.println("Sum is 16: "+s.checkForSum(list, 16));
		System.out.println("Sum is 15: "+s.checkForSum(list, 15));
	}
}
