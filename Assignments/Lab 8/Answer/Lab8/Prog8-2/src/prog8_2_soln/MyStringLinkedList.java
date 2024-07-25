package prog8_2_soln;

public class MyStringLinkedList {
	Node header;
	MyStringLinkedList(){
		header = new Node(null,null, null);
	}
	public void addFirst(String item){
		Node n = new Node(header.next,header,item);
		if(header.next != null){
			header.next.previous = n;
		}		
		header.next = n;
	}
	void printNodes() {
		Node next = header.next;
		if(next == null) System.out.println("");
		else {
			String s= next.toString();
			System.out.println(s);
		}
	}
	/**
	 * Sort Functions
	 * Start 
	 * */
	public void sort() {  
        Node current = header.next;
        if(header == null) {  
            return;  
        }  
        else {  
            while(current != null) {
            	minNode(current);  
                current = current.next;  
            }      
        }
	}
	void swap(Node n1, Node n2) {
		if(n1.value.compareTo(n2.value)==0) return;
		String temp = n1.value;
		n1.value = n2.value;
		n2.value = temp;
	}
	//find minimum of Node between the indices bottom and top
	Node minNode(Node n) {
        Node current = header.next;  
        if(header == null) {  
            System.out.println("List is empty");  
        }  
        else {  
            while(current != null) {
            	if(current.value.compareTo(n.value) < 0) {  
            		swap(n,current); 
            		//n = current;
            	}
            	current = current.next;
            } 
        }  
        return n;
	}
	/**
	 * Sort Functions
	 * End 
	 * */	
	//inserts a new Node containing data so that its
	//position in the list is now pos
	void insert(String data, int pos) {
		int size = size();
		Node temp = header;
		if(pos < 0 || pos > size) {
			throw new IllegalArgumentException(
				"Illegal position for new node");
		}
		/*else if(pos == size) { 
			while(temp.next != null) {
				temp = temp.next;
			}
			new Node(temp,header,data);
		}*/
		else if(pos == 0) 
			addFirst(data);
		else {
			Node n = new Node(null,null,data);
			//startNode will not be null  here
			
			int count = 1;
			while(count < pos) {
				temp = temp.next;
				count++;
			} 
			//insert n between temp and temp.node
			Node last = temp.next;
			temp.next = n;
			n.next = last;  //placing n into position pos
		}
	}
	//attempts to remove the first Node that contains
	//data; if successful, returns true; otherwise, false.
	boolean remove(String data) {
		if(data == null) return false;
		if(header != null && header.value.equals(data)){
			header = header.next;
			return false;
		}
		while(this.header.next != null) {
			if(data.equals(this.header.next.value)) {
				this.header.previous.value = this.header.next.value;
				return true;
			}
			this.header.previous = this.header.next;
		}
		return false;
	}
	//recursively attempts to find a String in some Node in the
	//list; returns true if found, false otherwise 
	boolean search(String data) {
		Node current = header.next;
		return recurSearch(data, current);
	}
	boolean recurSearch(String data,Node indexSearch) {
		if(indexSearch == null) return false;
		if(indexSearch.value.compareTo(data) == 0) return true;
		indexSearch =indexSearch.next;
		return recurSearch(data,indexSearch);
	}
	/** size = the number of non-null nodes */
	int size() {
		if(header == null) return 0;
		Node temp = header;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;	
	}

	class Node {
		String value;
		Node next;
		Node previous;
		Node(Node next, Node previous, String value){
			this.next = next;
			this.previous = previous;
			this.value = value;
		}
		@Override
		public String toString() {
		    if(value == null) return "";
			StringBuilder sb = new StringBuilder(value + " ");
			sb = toString(sb, next);
			return sb.toString();
		}
		private StringBuilder toString(StringBuilder sb, Node n) {
			if(n == null) return sb;
			sb.append(n.value + " ");
			return toString(sb, n.next);
		}	
	}
	
	public static void main(String[] args) {
		MyStringLinkedList list = new MyStringLinkedList();
		list.addFirst("big");
		list.addFirst("small");
		list.addFirst("tall");
		list.addFirst("short");
		list.addFirst("round");
		list.addFirst("square");
		list.addFirst("enormous");
		list.addFirst("tiny");
		list.addFirst("gargantuan");
		list.addFirst("lilliputian");
		list.addFirst("numberless");
		list.addFirst("none");
		list.addFirst("vast");
		list.addFirst("miniscule");
		//list.insert("555555", 5);
		System.out.println("Before Sort:");
		list.printNodes();
		System.out.println("After Sort:");
		list.sort();
		list.printNodes();
		
		System.out.println("\nSearch By Search Class:");
		System.out.println("\"number\" Search: "+list.search("number"));
		System.out.println("\"tiny\" Search: "+list.search("tiny"));
	}
}