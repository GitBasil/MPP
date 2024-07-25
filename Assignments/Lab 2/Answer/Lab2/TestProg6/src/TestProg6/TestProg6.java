package TestProg6;

import org.junit.Test;

import Prog6.Prog6;

public class TestProg6 {
	@Test
	public void testProg() {
		String[] testData = {"horse", "dog", "cat", "horse","dog"};
		//String[] result = Prog6.removeDups(testData);
		Prog6.removeDups(testData);
	}
}
