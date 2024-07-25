package lesson9.labs.prob10c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(
			1,
			2,
			3
		));

		Stream<Integer> ints = l1.stream();
		IntSummaryStatistics iss = ints.collect(Collectors.summarizingInt(p -> p));

		System.out.println(iss.getMin());
		System.out.println(iss.getMax());
    }

}
