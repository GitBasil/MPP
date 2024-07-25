package PlayGround;

import java.util.stream.Stream;

public class reduce_1 {

    public static void main(String[] args) {
        Stream<String> strings = Stream.of("Alice", "Bob", "Charlie", "David");
        String str =strings.reduce("",(x,y) -> x.concat(y).concat(" "));
        System.out.println(str);
    }
}