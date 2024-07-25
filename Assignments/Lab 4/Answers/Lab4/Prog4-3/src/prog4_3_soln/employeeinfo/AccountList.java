package prog4_3_soln.employeeinfo;

public class AccountList {
	private final int INITIAL_LENGTH = 5;	
	private Account[] acctArray;
	private int size;
	
	public AccountList() {
		acctArray = new Account[INITIAL_LENGTH];
		size = 0;
	}
	public void add(Account s){
		if(size == acctArray.length) resize();
		acctArray[size++] = s;
	}
	public Account get(int i){
		if(i < 0 || i >= size){
			return null;
		}
		return acctArray[i];
	}
	public boolean find(Account s){
		for(Account test : acctArray){
			if(test.equals(s)) return true;
		}
		return false;
	}
	private void resize(){
		System.out.println("resizing");
		int len = acctArray.length;
		int newlen = 2*len;
		Account[] temp = new Account[newlen];
		System.arraycopy(acctArray, 0, temp, 0, len);
		acctArray = temp;
	}
	public int size() {
		return size;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < size-1; ++i){
			sb.append(acctArray[i]+", ");
		}
		sb.append(acctArray[size-1]+"]");
		return sb.toString();
	}

}
