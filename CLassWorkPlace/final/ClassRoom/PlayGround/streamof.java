package PlayGround;

import java.util.stream.Stream;

public class streamof {

    public static int gcountOccurrences(String[] arr, String target) {
        int count = 0;
        if (target == null) {
            for (String item : arr)
                if (item == null)
                    count++;
        } else {
            for (String item : arr)
                if (target.equals(item))
                    count++;
        }
        return count;
    }

    public static int gscountOccurrences(String[] arr, String target) {
        return (int) Stream.of(arr)
                .filter(x -> (target == null && x == null) || x.equals(target))
                .count();
    }

    public static <T> int countOccurrences(T[] arr, T target) {
        int count = 0;
        if (target == null) {
            for (T item : arr)
                if (item == null)
                    count++;
        } else {
            for (T item : arr)
                if (target.equals(item))
                    count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs = new String[5];
        strs[0] = "a";
        strs[1] = "b";
        strs[2] = "c";
        strs[3] = "d";
        strs[4] = "a";

       System.out.println(streamof.gscountOccurrences(strs, "a"));
       System.out.println(streamof.gcountOccurrences(strs, "a"));
       System.out.println(streamof.countOccurrences(strs, "a"));
    }
    
    
}
