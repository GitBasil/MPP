package QuizAssignment.Quiz3;

import java.util.List;
import java.util.function.BiFunction;

public class Utli {

    public static final BiFunction<List<Customer>, String, List<String>> CUSTOMERS_FROM_CITY = (list, city) -> 
        list.stream()
        .filter(f -> f.getCity().equals(city))
        .map(m -> m.getName())
        .toList();

}
