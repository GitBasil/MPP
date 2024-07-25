package PlayGround;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class stream_1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Calling the old pickName method
        System.out.println("Using pickName_old:");
        pickName_old(names, "A");
        pickName_old(names, "B");
        pickName_old(names, "E");

        // Calling the new pickName method
        System.out.println("Using pickName_new:");
        pickName_new(names, "A");
        pickName_new(names, "B");
        pickName_new(names, "E");
    }

    public static void pickName_old(final List<String> names, final String startingLetter) {
        String foundName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                foundName = name;
                break;
            }
        }
        System.out.print(String.format("A name starting with %s: ", startingLetter));
        if (foundName != null) {
            System.out.println(foundName);
        } else {
            System.out.println("No name found");
        }
    }

    public static void pickName_new(final List<String> names, final String startingLetter) {
        final Optional<String> foundName = names.stream()
            .filter(name -> name.startsWith(startingLetter))
            .findFirst();

        System.out.println(
            String.format("A name starting with %s: %s", 
            startingLetter, 
            foundName.orElse("No name found")));
    }


}