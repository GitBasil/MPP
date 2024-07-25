package lesson9.labs.prob9;

import java.util.stream.IntStream;

public class Main {

    public static void printSquares(int num) {

        int[] nums = IntStream.iterate(1, n -> nextSquare(n + 1)).limit(num).toArray();
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static int nextSquare(int current) {
        int n = (int) Math.sqrt(current);
        n++;
        return n * n;
    }
    
    public static void main(String[] args) {
        Main.printSquares(4);
    }

}
