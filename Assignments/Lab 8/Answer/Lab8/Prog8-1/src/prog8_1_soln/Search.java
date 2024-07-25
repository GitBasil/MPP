package prog8_1_soln;
class Search {
	String[] anArray;
	//anArray is a sorted array
	Search(String[] anArray){
		this.anArray = anArray;
	}
	//search a sorted array
	boolean search(String val) {
		boolean b = recurse(0,anArray.length-1, val);
		return b;
	}
	boolean recurse(int a, int b, String val) {
		int mid = (a+b)/2;
		if(val.compareTo(anArray[mid]) == 0) return true;
		if(a > b) return false;
		if(val.compareTo(anArray[mid]) > 0) return recurse(mid+1, b, val);
		return recurse(a,mid-1,val);
	}
}