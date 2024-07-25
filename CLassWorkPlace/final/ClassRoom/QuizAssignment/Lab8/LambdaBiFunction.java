import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class LambdaBiFunction {
    public static void main(String[] args) {
        // Define the lambda expression as a BiFunction
        BiFunction<Double, Double, List<Double>> biFunction = (x, y) -> {
            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x, y));
            list.add(x * y);
            return list;
        };

        // Call the apply method with arguments 2.0 and 3.0
        List<Double> result = biFunction.apply(2.0, 3.0);

        // Print the result to the console
        System.out.println(result);
    }
}
