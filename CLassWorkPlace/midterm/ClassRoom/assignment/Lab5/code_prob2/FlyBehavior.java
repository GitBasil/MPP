package ClassRoom.assignment.Lab5.code_prob2;

public interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly with wings");
    }
}

class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("cannot fly");
    }
}