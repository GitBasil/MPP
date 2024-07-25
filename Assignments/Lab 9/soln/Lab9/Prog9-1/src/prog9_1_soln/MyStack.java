package prog9_1_soln;
public class MyStack {
	private MyStringLinkedList list;
	public MyStack() {
		list = new MyStringLinkedList();
	}
	
	public String pop() {
		if(list.header == null) return null;
		String s = peek();
		list.remove(list.find(s));
		return s;
	}
	public String peek() {
		if(list.header == null) return null;
		return list.header.next.value;
	}
	
	public void push(String s) {
		if(s==null) return;
		if(list.header==null) 
			list.header = list.add(s);
		else 
			list.header.next = list.add(s);
		
	}
	public static void main(String[]args){
		MyStack stack = new MyStack();
		stack.push("Bob");
		stack.push("Harry");
		stack.push("Alice");

		System.out.println("Popping…"+stack.pop());
		System.out.println("Peeking…."+stack.peek());
		System.out.println("Popping…"+stack.pop());
		//System.out.print(stack.list.size());
	}
}
