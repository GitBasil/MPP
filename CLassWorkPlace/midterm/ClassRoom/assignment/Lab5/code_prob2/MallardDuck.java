package ClassRoom.assignment.Lab5.code_prob2;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}

class RedheadDuck extends Duck {
    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}

class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new CannotFly();
        Squeak preBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}

class DecoyDuck extends Duck {
    public DecoyDuck() {
        flyBehavior = new CannotFly();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("displaying");
    }
}
