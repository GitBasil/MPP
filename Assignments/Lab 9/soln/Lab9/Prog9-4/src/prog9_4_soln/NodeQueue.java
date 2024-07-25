package prog9_4_soln;

public class NodeQueue {
	/* stores the element at the front of the queue, if it exists */
	private Node head;
	/* stores the element at the end of the queue, if it exists */
	private Node tail;
	
	/**
	 * Inserts a new node containing s at end of queue
	 */
	public void enqueue(String s) {
		Node newTop = new Node();
		newTop.data = s;
		if (tail != null) {
			tail.next = newTop;
        }
		tail = newTop;
        if(isEmpty()) {
        	head = tail;
        }
	}	
	/**
	 * Removes node from the front of the queue and returns its value if
	 * head is n
	 */
	public String dequeue() throws QueueException {
		if(isEmpty()) throw new QueueException("Queue is empty!");
        String sData = head.data;

        head = head.next;

        if (head == null) {
            tail = null;
        }
        return sData;
	}	
	/**
	 * Returns value stored at the front of the queue
	 * @return
	 * @throws QueueException
	 */
	public String peek() throws QueueException {
		if(isEmpty()) throw new QueueException("Queue is empty!");
		return tail.data;
	}
	public boolean isEmpty() {
		return head == null;
	}
	@Override
	public String toString() {
		if(isEmpty()) return "<empty queue>";
		return head.toString();
	}
}