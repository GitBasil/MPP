package PlayGround;

import java.util.function.BiFunction;

public class lambdatest {

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
