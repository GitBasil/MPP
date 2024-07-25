package One.prob6_exam_quiz;


import java.util.*;

public class GenericMergeSimple1_V2 {
	public static <T extends Comparable<T>> List<T> merge(List<T> list1, List<T> list2) {
		List<T> result = new ArrayList<T>(list1.size() + list2.size());
		int i =0, j=0, pos =0;
		while(i<list1.size() && j < list2.size()){
			if (list1.get(i).compareTo(list2.get(j))<=0){
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
		List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10, 11, 12);
		List<String> strlist1 = Arrays.asList("andy", "bill","mike");
		List<String> strlist2 = Arrays.asList("anita", "cindy","joe");
		System.out.println(merge(strlist1, strlist2));
		System.out.println(merge(list1, list2));
	}

}
