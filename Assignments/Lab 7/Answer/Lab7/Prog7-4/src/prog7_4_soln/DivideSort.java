package prog7_4_soln;

public class DivideSort {
	Merge mString = new Merge();
	public String divideSort(String s) {
		if(s.length()==0 || s.length()==1) return s;
		int len = s.length() / 2;
		String sLeft = s.substring(0,len-1);
		String sRight = s.substring(len);
		return mString.merge(sLeft,sRight);
	}
}
