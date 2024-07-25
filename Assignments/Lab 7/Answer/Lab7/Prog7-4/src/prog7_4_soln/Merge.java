package prog7_4_soln;
public class Merge {
	StringBuilder ret = new StringBuilder();
	String merge(String s, String t) {	
		if(s.isEmpty() && t.isEmpty()) return ret.toString();
		if(s.isEmpty()) {
			ret.append(t);
			return ret.toString();
		}
		if(t.isEmpty()) {
			ret.append(s);
			return ret.toString();
		}
		if(s.charAt(0) <= t.charAt(0)) {
			ret.append(s.charAt(0));
			return merge(s.substring(1), t);
		} else {
			ret.append(t.charAt(0));
			return merge(s, t.substring(1));
		}
		
	}
	public static void main(String[] args) {
		Merge ms = new Merge();
		System.out.println(ms.merge("ace", "bd"));
	}
}
