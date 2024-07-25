package One.prob6_exam_quiz;


import java.util.*;

public class GenericMergeSimple1_V3 {
	public static <T,S> List<?> merge(List<T> list1, List<S> list2,
			BiComparator<T, S> comparator) {
		//List<? extends Object>
		List<Object> result = new ArrayList<>(list1.size() + list2.size());
		int i =0, j=0, pos =0;
		while(i<list1.size() && j < list2.size()){
			if (comparator.compare(list1.get(i), list2.get(j)) <=0 ){
				result.add(pos, list1.get(i));
				i++;
				pos++;
			}
			else{
				result.add(pos, list2.get(j));
				j++;
				pos++;
			}
		}
		while(i<list1.size()){
			result.add(pos++, list1.get(i++));
		}
		while(j<list2.size()){
			result.add(pos++, list2.get(j++));
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
		List<String> strlist1 = Arrays.asList("ann", "bill","mike");
		BiComparator<String, Integer> comp = new BiComparator<String, Integer>() {
			@Override
			public int compare(String s, Integer t) {
				return new Integer(s.length()).compareTo(t);
			}
		};
		BiComparator<String, Employee> comp1 = new BiComparator<String, Employee>() {
			@Override
			public int compare(String s, Employee t) {
				return s.compareTo(t.getName());
			}
		};
		System.out.println(merge(strlist1, list1, comp));
	}

}
