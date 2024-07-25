package Practice_mdExam.midterm_test.pg1;

class One {
    One(){
        System.out.println("One");
    }

    public static void print(){
        System.out.println("Parent");
    }
}

class Two extends One {
    Two(){
        System.out.println("Two");
    }
}

public class Test_1 {
    public static void main(String[] args) {
        One one = new Two();
    }
}
