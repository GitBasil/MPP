package lesson9.labs.prob10b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>(Arrays.asList(
			"Bill",
			"Thomas",
			"Mary"
		));

		System.out.println(l1.stream().reduce("", (x,y) -> x.isEmpty() ? y : x + ", " + y));
    }

}
