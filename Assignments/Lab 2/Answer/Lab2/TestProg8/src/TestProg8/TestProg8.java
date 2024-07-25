package TestProg8;
import org.junit.Test;
import Prog8.Prog8;

public class TestProg8 {
	@Test
	public void testProg() {
		int numbers[] = {2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22};
		System.out.println(Prog8.min(numbers));
	}
}
