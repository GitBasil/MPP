package PlayGround;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class testing {

    public static ArrayList<String> combine(Stream<ArrayList<String>> stream) {
        return stream.reduce(new ArrayList<>(), (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        });
    }
    
    public static <T extends Comparable<T>> T min(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        T min = list.get(0);
        for (T element : list) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }

    public static <T extends Comparable<T>> T min1(List<T> list) {
        return list.stream()
                .min((o1, o2) -> o1.compareTo(o2))
                .orElse(null);
    }
    public static void main(String[] args) {
        // Example usage
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("there");
        
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("goodbye");
        list2.add("again");

        Stream<ArrayList<String>> cm = Stream.of(list1,list2);

        ArrayList<String> list3 = combine(cm);
        System.out.println(list3);


        List<Integer> integers = List.of(3, 5, 1, 4, 2);
        System.out.println("Min of integers: " + min(integers)); 
    }
}
