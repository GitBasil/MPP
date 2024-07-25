package prog7_2_soln;

public class MinSort {
	private StringBuilder str = new StringBuilder();
	
	public void minSort() {}
	public String sort(String s) {
		int minPosition = 0;
		if(s.length()==0 || s == null) return null;
		//if(s.length()==1) return s;
		for(int i = 0;i < s.length();i++) {
			//System.out.println(s.charAt(minPosition)+" + "+s.charAt(i));
			if(s.charAt(minPosition) > s.charAt(i))
				minPosition = i;
		}
		//System.out.println(minPosition+" - "+s);
		str.append(s.charAt(minPosition));
		s = s.substring(0,minPosition) + s.substring(minPosition+1);
		sort(s);
		return str.toString();
	}
}
