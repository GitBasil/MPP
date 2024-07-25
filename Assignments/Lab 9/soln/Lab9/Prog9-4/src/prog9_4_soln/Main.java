package prog9_4_soln;

public class Main {
	public static void main(String[] args) {
			NodeQueue theQueue = new NodeQueue(); // queue holds 5 items
			try {
				theQueue.dequeue();
			} catch(Exception e) {
				if(e.getClass() != QueueException.class) {
					System.out.println("The wrong kind of exception was just thrown");
				} else {
					System.out.println(e.getMessage());
				}
			}
			theQueue.enqueue("1"); 
			theQueue.enqueue("2");
			theQueue.enqueue("3");
			theQueue.enqueue("4");
			theQueue.enqueue("5");
			System.out.println(theQueue);
			try {
				//System.out.println(theQueue.peek());
				for(int i = 0; i < 5; ++i) {
					System.out.println("Removed " + theQueue.dequeue());
				}
			} catch(QueueException e) {
				System.out.println("Unexpected QueueException while dequeueing");
			}
			System.out.println("Is the queue empty? " + theQueue.isEmpty());
		

	}

}
