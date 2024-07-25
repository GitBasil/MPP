package PlayGround.pretestcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Employee {
    String name;
    int salary;

    public Employee(String n, int s) {
        this. name = n;
        this. salary = s;
    }

    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Salary: " + this.salary;
    }
}


public class l9 {

    Function<Employee, String> byName = e -> e.getName();
    Function<Employee, Integer> bySalary = e -> e.getSalary();

    public void sort(List<Employee> emps, final int method) {
        if (method == 0) {
            Collections.sort(emps, Comparator.comparing(byName).thenComparing(bySalary));
            emps = emps.stream().sorted((Employee x, Employee y) -> x.getSalary() - y.getSalary()).toList();
            emps = emps.stream().sorted(Comparator.comparing(byName).thenComparing(bySalary)).toList();
        } else {
            Collections.sort(emps, Comparator.comparing(bySalary).thenComparing(byName));
        }
    }

    public static String getNUllValue() {
        // Return null to simulate a value that might be absent
        return null;
    }

    public static List<Character> characterList(String s) {
        List<Character> result = new ArrayList<>();
        for (char c : s.toCharArray())
            result.add(c);
        return result;
    }


    static BiFunction<List<String>, String, Stream<String>> SEARCH_IN_LIST = (x,y) -> x.stream().filter(f -> f.contains(y));


    public static void main(String[] args) {

        List<String> words = List.of("example", "words", "for", "stream", "filter", "count");

        final long count = words.stream()
                                .filter(w -> w.length() > 4)
                                .count();
        final long pcount = words.parallelStream()
                                .filter(w -> w.length() > 4)
                                .count();

        System.out.println("Number of words longer than 4 characters: " + count);
        System.out.println("Number of words longer than 4 characters: " + pcount);

        /*
         * Stream.of
         */
        Integer[] arrOfInt = {1, 3, 5};
        Stream<Integer> strOfInt = Stream.of(arrOfInt);

        int[] arrOfInt1 = {1, 3, 5};
        //one element Stream
        Stream<int []> strOfInt1 = Stream.of(arrOfInt1);

        Stream<String> song = Stream.of("gently", "down", "the");

        /*
         * iterate
         */
        List<Integer> ll = Stream.iterate(1, n -> n + 2).limit(8).skip(4).toList();
        ll.forEach(System.out::println);
        /*
         * generate
         */
        Stream<String> echoes = Stream.generate(() -> "echo").limit(4);
        echoes.forEach(System.out::println);


        /*
         * map vs flatMap
         */
        List<String> list = Arrays.asList ("Joe", "Tom", "Abe");
        Stream<Stream<Character>> result1 = list.stream ()
                                                .map(s -> l9.characterList(s).stream());
        Stream<Character> result2 = list.stream ()
                                        .flatMap(s -> l9.characterList(s).stream());

        //sort by decreasing lengths of words
        List<String> longestFirst = words.stream()
                                            .sorted((String x, String y) -> y.length() - x.length())
                                            .toList();
        System.out.println(longestFirst);
        //sort by decreasing lengths of words using Comprator
        List<String> longestFirst1 = words.stream()
                                            .sorted(Comparator.comparing((String x) -> x.length()).reversed())
                                            .toList();
        System.out.println(longestFirst1);


        /*
         * max, min, findFirst , findAny return an optional value, you need to handle it properly or it will threw an error
         */
        Optional<String> fs = words.stream()
                            .filter(f -> f.startsWith("E"))
                            .findFirst();
        if(fs.isPresent()){
            System.out.println(fs.get());
        }
        System.out.println(fs.orElse("Not Found"));
        // findFirst, min and max best to use stream
        // findAny use parallelStream

        // when you use orElse or orElseGet in the lambda the return will not be optional any more
        String fs1 = words.stream()
                            .filter(f -> f.startsWith("E"))
                            .findFirst()
                            .orElse("N/A");
        System.out.println(fs1);

        /*
         * ofNullable example
         */
        String outputMessage = "Hello ";
        String value = l9.getNUllValue();
        System.out.println(value);
        Optional<String> optionalValue = Optional.ofNullable(value);

        outputMessage += Optional.ofNullable(l9.getNUllValue()).orElse("World!");
        System.out.println(outputMessage);

        /*
         * Use reduce only on operations that are commutative and associative.
         */
        String str =words.stream().reduce("",(x,y) -> x.concat(y).concat(" "));
        System.out.println(str);

        System.out.println(Stream.generate(() -> "echo").limit(4).reduce("", (x,y) -> x + " " + y));
        System.out.println(Stream.iterate(1, n -> n + 2).limit(8).reduce(0, (x,y) -> x + y));

        /*
         * collect results
         */
        String[] r1 = words.stream().toArray(String[]::new);
        List<String> r2 = words.stream().collect(Collectors.toList());
        Set<String> r3 = words.stream().collect(Collectors.toSet());
        TreeSet<String> r4 = words.stream().collect(Collectors.toCollection(TreeSet::new));
        String r5 = words.stream().collect(Collectors.joining (", "));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 50000));
        employees.add(new Employee("Jane Smith", 60000));
        employees.add(new Employee("Alice Johnson", 55000));
        employees.add(new Employee("Bob Brown", 70000));
        Map<String, Employee> r6 = employees.stream().collect(Collectors.toMap ( Employee::getName ,Function.identity()));

        // DoubleSummaryStatistics summary = data.stream().collect(Collectors.summarizingDouble(p -> p.getTestScore()));
        IntSummaryStatistics summary = employees.stream().collect(Collectors.summarizingInt(Employee::getSalary));
        double averageTestScore = summary.getAverage();
        int maxTestScore = summary.getMax();
        int minTestScore = summary.getMin();
        long countTestScore = summary.getCount();
        long sumTestScore = summary.getSum();
        System.out.println("Average Test Score: " + averageTestScore);
        System.out.println("Max Test Score: " + maxTestScore);

        /*
        * For primitive types short , char , byte , and boolean , use IntStream ; 
        * for floats , use DoubleStream .
        */
        IntStream ints = IntStream.of (1, 2, 3, 4);
        DoubleStream ones = DoubleStream.generate (() -> 1.0);
        LongStream naturalNums = LongStream.iterate (1, n -> n + 1);
        // Upper bound is excluded
        IntStream zeroToNinetyNine = IntStream.range(0, 100);
        // Upper bound is included
        IntStream zeroToHundred = IntStream.rangeClosed(0, 100);

        //To convert a primitive type stream to an stream of objects, use the boxed() method:
        Stream<Integer> integers = IntStream.range(0, 100).boxed();

        // To convert an object stream to a primitive type stream, there are methods mapToInt , mapToLong , and mapToDouble
        IntStream lengths = words.stream().mapToInt(String::length);

        Stream<String> ss = l9.SEARCH_IN_LIST.apply(words,"E");

    }
}
