package two.prob4;


public class Pair {
	private int first;
    private int second;

    public Pair(int key, int value) {
		this.first = key;
		this.second = value;
    }
 
    public String toString(){
    	return "[" + first + ", " + second + "]";
    }
}