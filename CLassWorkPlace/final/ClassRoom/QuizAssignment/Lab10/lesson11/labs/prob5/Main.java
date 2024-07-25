package lesson11.labs.prob5;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static <T extends Comparable<? super T>> Optional<T> secondSmallest(List<T> list) {
        return list.stream()
        .distinct()
        .sorted()
        .skip(1)
        .findFirst();
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(4, 2, 5, 1, 3, 2);
        List<String> stringList = List.of("apple", "banana", "cherry", "apple", "date");
        List<LocalDate> dateList = List.of(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2022, 12, 25),
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2022, 11, 30)
        );

        Optional<Integer> secondSmallestInt = secondSmallest(intList);
        secondSmallestInt.ifPresentOrElse(
            value -> System.out.println("Second smallest number is: " + value),
            () -> System.out.println("The list does not contain enough distinct numbers.")
        );

        Optional<String> secondSmallestString = secondSmallest(stringList);
        secondSmallestString.ifPresentOrElse(
            value -> System.out.println("Second smallest string is: " + value),
            () -> System.out.println("The list does not contain enough distinct elements.")
        );

        Optional<LocalDate> secondSmallestDate = secondSmallest(dateList);
        secondSmallestDate.ifPresentOrElse(
            value -> System.out.println("Second smallest date is: " + value),
            () -> System.out.println("The list does not contain enough distinct elements.")
        );
    }
}
