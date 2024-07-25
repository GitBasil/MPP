package QuizAssignment.lesson9.startupCodeLab9Part1.prob4;

import java.util.List;
import java.util.stream.Stream;

public class PrimeStream {
    
    public static void main(String[] args) {
        PrimeStream ps = new PrimeStream(); //PrimeStream is enclosing class ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);
        ps.printFirstNPrimes(15);
    }

    void printFirstNPrimes(long x) {
         Stream<Integer> ints = Stream.iterate(1, n -> {
            int next = n + 1;
            while (!isPrime(next)) {
                next++;
            }
            return next;
        });
        List<Integer> intsss = ints.limit(x).toList();
        System.out.println(intsss);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
