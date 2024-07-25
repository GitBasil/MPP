package lesson7.exercise_4_soln.prob1;

public interface Iface2 {
	default int myMethod(int x) {
		return 2 * x;
	}
}
