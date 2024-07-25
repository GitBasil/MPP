package prog7_3_soln;

import org.junit.Test;

import junit.framework.TestCase;

public class BinSearch extends TestCase {
	private StringBuilder str = new StringBuilder();
	public void binSearch() {
		
	}
	@Test
	public boolean search(String str,char c) {
		if(str.length()==0) return false;
		boolean result = false;
		int len = str.length() / 2;
		if(len==0) return result;
		if(str.charAt(len) == c)
			return true;
		else if(str.charAt(len) > c)
			result = search(str.substring(0,len),c);
		else if(str.charAt(len) < c)
			result = search(str.substring(len),c);
		return result;
	}
	public String sort(String s) {
		int minPosition = 0;
		if(s.length()==0 || s == null) return null;
		for(int i = 0;i < s.length();i++) {
			if(s.charAt(minPosition) > s.charAt(i))
				minPosition = i;
		}
		str.append(s.charAt(minPosition));
		s = s.substring(0,minPosition) + s.substring(minPosition+1);
		sort(s);
		return str.toString();
	}
}
