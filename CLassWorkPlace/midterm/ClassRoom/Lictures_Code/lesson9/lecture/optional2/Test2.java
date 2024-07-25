package lesson9.lecture.optional2;

import java.util.Optional;

public class Test2 {
public static Optional<Double> divide(Double a,Double b)
{
	return Optional.ofNullable(a/b);
}
	public static void main(String[] args) {
		System.out.println(divide(4.0,2.0).get());

	}

}
