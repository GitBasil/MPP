package lesson9.labs.prob12;

import java.util.Optional;

public class MySingletonLazy {
    private static Optional<MySingletonLazy> instance = Optional.empty();
    private MySingletonLazy() {}
    public static MySingletonLazy getInstance() {
        instance = Optional.ofNullable(instance.orElseGet(() -> new MySingletonLazy()));
        return instance.get();
    }


    public static void main(String[] args) {
        MySingletonLazy singleton1 = MySingletonLazy.getInstance();
        MySingletonLazy singleton2 = MySingletonLazy.getInstance();

        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}
