package prog7_3_soln;
//import org.junit.Test;
import junit.framework.TestCase;
public class Main extends TestCase {
	public static void main(String[] args) {
		BinSearch bsearch = new BinSearch();
		String str = "Mohammed AlDini";
		str = bsearch.sort(str.toLowerCase());
		System.out.println(bsearch.search(str,'m'));
		System.out.println(bsearch.search(str,'r'));
	}

}
