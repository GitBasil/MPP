package PlayGround.pretestcodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Interface with default/static methods 
 */
interface StringList {
    String[] strArray();
	int size();
	void incrementSize();

    default String get(){
        return strArray()[size()];
    }

    default void add(String str) {
        strArray()[size()] = str;
        incrementSize();
    }

    static void print()
    {
        System.out.println("Print");
    }
}

/** 
 * Controlling constants with enums
*/
enum Size {SMALL, MEDIUM, LARGE}

/**
 * Run time error and no control with compiler when using class constants
 */
class cSize{
    public static final int SMALL = 0;
    public static final int MEDIUM = 1;
    public static final int LARGE = 2;
}

/**
 * Enums with default values
 */
enum DIM{
    LENGTH(1.0),
    WIDTH(2.0);

    double val;
    DIM(double val){
        this.val = val;
    }
    public double val(){
        return val;
    }
}


/**
 * Enum with multiple value types
 */
enum Constants {
    COMPANY("Microsoft"),
    SALES_TARGET(10000);

    String str;
    Constants(String str){
        this.str = str;
    }
    int i;
    Constants(int i){
        this.i = i;
    }

    public int getI() {
        return i;
    }
    public String getStr() {
        return str;
    }
}

/**
 * Enum Singletom example
 */
enum MySingleton {
    INSTANCE;
    public void behavior() {
        System.out.println("MySingleton");
    }
}


/**
 * Example that enum can implement multple interfaces
 */
interface DisplayItem {
    default void displayInfo() {
        System.out.println("Interface");
    }
}
enum DinosaurStatue implements DisplayItem {
    INSTANCE;
}


/*
 * Overriding equal from object class
 * instanceof vs getClass
 * instanceof check if the class is the same or child of the same class
 * getClass will get the exact class that you are passing
 */
class Person {

    private String name;
    Person(String n) {
        name = n;
    }
    @Override
    public boolean equals(Object aPerson) {
        if(aPerson == null) return false; 
        if(!(aPerson instanceof Person)) return false;
        Person p = (Person)aPerson;
        boolean isEqual = this.name.equals(p.name);
        return isEqual;
    }
}

class Person2 {

	protected String name;
	Person2(String n) {
		name = n;
	}
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(aPerson.getClass() != this.getClass()) return false;
		Person2 p = (Person2)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
}

class PersonWithJob extends Person2 {
	private double salary;
	PersonWithJob(String n, double s) {
		super(n);
		salary = s;
	}

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object aPerson) {
        if(aPerson == null) return false;
        if(!(aPerson.getClass() == this.getClass())) return false;
        PersonWithJob pj = (PersonWithJob) aPerson;
        boolean eq = this.name.equals(pj.name) && this.getSalary() == pj.getSalary();
        return eq;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,salary);
    }
}


public class l7 {

    static Consumer<String> cons = new Consumer<String>() {
        public void accept(String t) {
            System.out.println(t);
        }
    };

    public static void main(String[] args) {

        int x = cSize.MEDIUM; // x = 1; compiler have no control 
        if( x == cSize.MEDIUM){
            System.out.println(x);
        }

        Size s = Size.MEDIUM; // compiler error if value is not part of the enum
        if(s == Size.MEDIUM) {
            System.out.println(s);
            System.out.println(DIM.LENGTH);
            System.out.println(DIM.LENGTH.val());
        }

        System.out.println(Constants.COMPANY.getStr());
        System.out.println(Constants.SALES_TARGET.getI());

        MySingleton.INSTANCE.behavior();
        DinosaurStatue.INSTANCE.displayInfo();

        List<String> lst = new ArrayList<>(
            List.of("A",
            "B",
            "C"
        ));
        lst.forEach(cons);
        lst.forEach(new Consumer<String>() {
            public void accept(String t) {
                System.out.println(t);
            };
        });
        lst.forEach(t -> System.out.println(t));
        lst.forEach(System.out::println);


        Person p1 = new Person("Joe");
        Person p2 = new Person("Joe");
        System.out.println("p1.equals(p2)? " + p1.equals(p2));

        Person2 p3 = new Person2("Joe");
		Person2 p4 = new PersonWithJob("Joe", 20000);
		
		System.out.println("p1.equals(p2)? " + p3.equals(p4));
		System.out.println("p2.equals(p1)? " + p4.equals(p3));

    }
}
