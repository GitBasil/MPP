package PlayGround;

import java.util.Arrays;
import java.util.List;

public class generic_02 {
    public static void main(String[] args) {
        // Generic class example
        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello");
        System.out.println("Generic Box Value: " + stringBox.getValue());

        // Wildcard example
        List<Integer> intList = List.of(1, 2, 3);
        printList(intList);

        List<String> strList = Arrays.asList("A", "B", "C");
        printList(strList);
    }

    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println("Wildcard List Element: " + element);
        }
    }
}

class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
