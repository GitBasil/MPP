package PlayGround.pretestcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;


interface Pair<K,V> {
    public K getKey();
    public V getValue();
}

class SimplePair<K, V> implements Pair<K,V> {
    private K key;
    private V value;

    public SimplePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class lambdatest {

    BiFunction<Double, Double, Boolean> lambda = (Double x, Double y) -> x * y < x + y;

    // Using the method reference to assign to the lambda
    public static boolean compare(Double x, Double y) {
        return x * y < x + y;
    }
    BiFunction<Double, Double, Boolean> lambda1 = lambdatest::compare;

    // Static nested class implementing BiFunction
    // Using an instance of the static nested class
    static class LambdaImplementation implements BiFunction<Double, Double, Boolean> {
        @Override
        public Boolean apply(Double x, Double y) {
            return x * y < x + y;
        }
    }
    BiFunction<Double, Double, Boolean> lambda2 = new LambdaImplementation();
}


public class l10 {

    public static <K,V> boolean compare(Pair<K,V> p1, Pair<K,V> p2){
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    public static <T extends Comparable<? super T>> T max1(List<T> list) {
        T max = list.get(0);
        for(T i : list) {
            if(i.compareTo(max) > 0) {
                max = i;
            }
        }
        return max;
    }

    public static <T> int countOccur(T[] arr, T e){
        return (int) Stream.of(arr).filter(f -> f == e)
                        .count();
    }

    public static <T extends Number> void addNumbers(Collection<T> nums, T e) {
        addEle(nums, e);
    }

    public static <T> void addEle(Collection<T> nums, T e){
        nums.add(e);
    }

    public static void addNumbers(List<? super Integer> nums, Integer e) {
        nums.add(e);
    }

    public static void main(String[] args) {
        // Sample data
        List<Integer> intList = Arrays.asList(1, 3, 7, 2, 5);
        List<String> strList = Arrays.asList("apple", "orange", "banana", "pear");

        // Find max in integer list
        Integer maxInt = max1(intList);
        System.out.println("Max Integer: " + maxInt);

        // Find max in string list
        String maxStr = max1(strList);
        System.out.println("Max String: " + maxStr);


        //public class MyList<T> extends ArrayList<T>
        //public class MyList extends ArrayList<String>
        Pair<Integer, String> pair1 = new SimplePair <>(10123, "Jim");
        Pair<Integer, String> pair2 = new SimplePair <>(10123, "Jim");
        Integer employeeId = pair1.getKey ();
        System.out.println(employeeId);

        //Type Erasure
        // will remove the generic type such as <String>, <Integer>, ...
        // will not remove the arrays such as string[], int[], ...

       System.out.println(l10.compare(pair1,pair2));


       List<Number> nums = new ArrayList <>();
       List<Integer> ints = Arrays.asList (1, 2);
       List<Double> doubles = Arrays.asList (2.78, 3.14);
       nums.addAll(ints);
       nums.addAll(doubles);
       System.out.println(nums);

       
    }

}
