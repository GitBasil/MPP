import java.util.function.Supplier;

public class RandomNumberPrinter {
    public static void main(String[] args) {
        Supplier<Double> randomSupplier = () -> Math.random();
        Double randomNumber = randomSupplier.get();
        System.out.println("Random Number: " + randomNumber);
    }
}