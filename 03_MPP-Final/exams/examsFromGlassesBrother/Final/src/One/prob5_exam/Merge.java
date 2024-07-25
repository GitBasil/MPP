package One.prob5_exam;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import One.prob6_exam_quiz.BiComparator;
public class Merge {

	/* For testing your implementation */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(2, 4, 6);
		List<Integer> list2 = Arrays.asList(3, 5, 6, 7);
		List<String> list3 = Arrays.asList("alice", "tom");
		List<String> list4 = Arrays.asList("Bob", "Richard");
		List<Double> list5 = Arrays.asList(2.3, 4.5);
		List<Number> list6 = Arrays.asList(2, 5);
		List<String> list7 = Arrays.asList("A", "XYZ", "AXTU");
		
		BiComparator<String, Integer> com = (x,y) ->{
		    return new Integer(x.length()).compareTo(y);
		};
		
		System.out.println(merge(list3, list1, com));
	}
	
	public static <T,R>List<?> merge(List<T> list1,List<R> list2, BiComparator<T, R> comparator) {
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
}
