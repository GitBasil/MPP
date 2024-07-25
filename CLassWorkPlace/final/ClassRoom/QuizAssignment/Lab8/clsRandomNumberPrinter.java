import java.util.function.Supplier;



public class clsRandomNumberPrinter  {

    static class implRandomNumberPrinter implements Supplier<Double> {
        @Override
        public Double get() {
            return Math.random();
        }
       
    }

    public static void main(String[] args) {
        Supplier<Double> f = new implRandomNumberPrinter();
        System.out.println("Random Number: " + f.get());
    }
}
