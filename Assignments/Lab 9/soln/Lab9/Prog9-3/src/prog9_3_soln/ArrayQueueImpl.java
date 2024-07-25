package prog9_3_soln;

public class ArrayQueueImpl {
	private int capacity = 10;
	private int[] arr = new int[capacity];
	private int size = 0;
	private int front = 0;
	private int rear = 0;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public void dequeue() {
		if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");
		front++;
		size--;
	}
	
	public int peek() {
		if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");
		return arr[front];
	}
	
	public void enqueue(int item) {
		if(size > capacity-1) {
			resize();
		}
		arr[rear] = item;
		rear++; 
		size++;
	}
	
	private void resize(){
		//ystem.out.println("resizing..."+arr.length);
		capacity = 2 * capacity;
		int[] temp = new int[capacity];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		arr = temp;
	}

	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();
		for(int i = 0; i < 15; i++)
			q.enqueue(i);
		for(int i = 0; i < 14; i++)
			q.dequeue();
		System.out.println(q.size());
		System.out.println(q.peek());
	}
}

