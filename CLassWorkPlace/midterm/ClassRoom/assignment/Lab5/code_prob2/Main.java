package ClassRoom.assignment.Lab5.code_prob2;

public class Main {
    public static void main(String[] args) {
        Duck[] ducks = {
            new MallardDuck(),
            new DecoyDuck(),
            new RedheadDuck(),
            new RubberDuck()
        };

        for (Duck d : ducks) {
            System.out.println(d.getClass().getSimpleName() + ":");
            d.display();
            d.performFly();
            d.performQuack();
            d.swim();
            System.out.println();
        }
    }
}
