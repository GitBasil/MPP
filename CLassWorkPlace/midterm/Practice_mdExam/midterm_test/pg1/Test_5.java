package Practice_mdExam.midterm_test.pg1;

public class Test_5 {
    public static void main(String[] args) {
        MySuperSuper mss = new MyClass();
        mss.myMethod();
    }
}

class MyClass extends MySuper {
    public void myMethod() {
        super.myMethod();
        System.out.print("Goodbye");
    }
}

class MySuper extends MySuperSuper {
    public void myMethod() {
        System.out.print("Hello ");
        super.myMethod();
    }
}

class MySuperSuper {
    public void myMethod() {
        System.out.print("Super super");
    }
}
