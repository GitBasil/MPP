package PlayGround;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class iterate {

    public static void main(String[] args) {
        // List<String> echos = Stream.generate(()-> "echo").limit(5).toList();
        // echos.forEach(System.out::println);

        // List<String> hellos = Stream.iterate("hello", str -> "hello").limit(5).toList();
        // hellos.forEach(System.out::println);


        List<Integer> ll = Stream.iterate(1, n -> n + 2).limit(8).skip(4).toList();
        ll.forEach(System.out::println);

        List<Integer> ll1 = Stream.iterate(1, n -> n + 2).skip(4).limit(4).toList();
        ll1.forEach(System.out::println);


        List<String> strings = new ArrayList<>(Arrays.asList("a","b","c","d"));
        String[] ss = strings.toArray(new String[0]);
        for (String string : ss) {
            System.out.println(string);
        }
    }
    
}