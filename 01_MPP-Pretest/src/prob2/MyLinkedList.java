package prob2;


public class MyLinkedList {
	//contains no data, cannot be removed
	private Node header = null; 
	
	/* Do not modify */
	public MyLinkedList() {
		//header should never be null
		header = new Node();
	}
	
	//IMPLEMENT
	public void addLast(String s) {
		
	}
	
	/* Do not modify */
	public void printNodes() {
		Node next = header.node;
		while(next != null) {
			System.out.print(next);
			next = next.node;
		}
		System.out.println();
	}
	
	/* Do not modify */
	public void addFirst(String s) {
		Node newNode = new Node();
		newNode.data = s;
		
		//link from newNode to current header.node
		newNode.node = header.node;
		
		//link from header to newNode
		header.node = newNode;		
	}
	
	/* Do not modify */
	private class Node {
		String data;
		Node node;
		
		@Override
		public String toString() {
			return data + " ";
		}
	}	
	
	public static void main(String[] args) {
		String[] stringData = {"Albert", "Billy", "Charles", "David", "Emma"};
		MyLinkedList mll = new MyLinkedList();
		//populate
		for(int i = stringData.length -1; i >= 0; i--) {
			mll.addFirst(stringData[i]);
		}
		mll.printNodes();
		mll.addLast("Frank");
		//expected output: Albert Billy Charles David Emma Frank
		mll.printNodes();
	}
}

