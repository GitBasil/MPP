package One.prob6_exam_quiz;


import java.util.*;

public class GenericMergeSimple1_V5 {
	public static <T,S> List<?> merge(List<? extends T> list1, List<? extends S> list2,
			BiComparator<? super T, ? super S> comparator) {
//		List<? extends Object>
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
		List<String> strlist1 = Arrays.asList("ann", "bill","mike");
		List<Manager> managerList = new ArrayList<Manager>(){
			{
				add(new Manager("andy", 3000));
				add(new Manager("charlie", 3000));
				add(new Manager("riwaj", 3000));
			}
		};
		
		BiComparator<String, Person> comp1 = new BiComparator<String, Person>() {
			@Override
			public int compare(String s, Person t) {
				return s.compareTo(t.getName());
			}
		};
		System.out.println(GenericMergeSimple1_V5.<String, Employee>merge(strlist1, managerList, comp1));
	}

}
