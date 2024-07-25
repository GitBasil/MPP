package lesson7.lecture.singletons;

/** Threadsafe singleton implementation; eager initialization */
public enum MySingletonEnum {
	INSTANCE;
public void print() {
	System.out.println("I am Singleton");
}
}
