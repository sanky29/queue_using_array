import java.util.Scanner;

//implement the queue in array
public class queue_using_array implements queue_using_arrayi {
	
	//define the array to implement the queue
	private Object queue[] = new Object[20];
	
	//define the front and back of the queue
	private int front,back = 0;
	
	//define the isEmpty function
	public boolean isEmpty() {
		
		//just return that r == f or not
		return(front == back);
	}
	
	//define the top function
	public Object top() {
		
		//if is empty then return exception
		if (front == back) {
			
			//throw the exception
			throw new IndexOutOfBoundsException("you have reached the bottom");
		}
		//else return element at front
		else {
			
			//just return element at front
			return(queue[front]);
		}
	}
	//define public dequeue function
	public Object dequeue() {
		
		//if is empty then return exception
		if (front == back) {
					
			//throw the exception
			throw new IndexOutOfBoundsException("you have reached the bottom");
		}
		//else return element at front
		else {
			//define temp variable to store the element
			int temp = front;
			
			//just change front to new front
			front = (front + 1)%(queue.length);
			
			//just return element at front
			return(queue[temp]);
		}
	}
	//define public dequeue function
	public void enqueue(Object new_element) {
		
		//if is empty then return exception
		if (back == front - 1) {
						
			//throw the exception
			throw new IndexOutOfBoundsException("the queue is full");
		}
		//else return element at front
		else {
				
			//just change the element
			queue[back] = new_element;
			
			//update the back
			back = (back + 1)%(queue.length);
		}
	}
	public static void main(String args[]) {
		queue_using_array s = new queue_using_array();
		Scanner scan = new Scanner(System.in);
		String temp = scan.nextLine();
		Integer t = 0;
		while (temp.matches("stop") != true) {
			
			switch(temp) {
			case "dq":
				System.out.println(s.dequeue());
				break;
			case "eq":
				t = scan.nextInt();
				s.enqueue(t);
				break;
			case "empty":
				System.out.println(s.isEmpty());
				break;
		
			case "top":
				System.out.println(s.top());
				break;
			}
			temp = scan.nextLine();
		}
		scan.close();
	}
}