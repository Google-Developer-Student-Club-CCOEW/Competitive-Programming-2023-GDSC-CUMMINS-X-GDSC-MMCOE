package hacktoberfest;
import java.util.*;

public class QueueUsingStacks {

	Stack<Integer> input;	// For pushing elements
	Stack<Integer> output;	// For popping and peeking elements
	
	// Constructor to initialize the Stacks
    public QueueUsingStacks() {
		input = new Stack<>();
		output = new Stack<>();
    }
    
    // Method to push element x to the end of queue
    public void push(int x) {
        System.out.println(x + " is pushed!");
        input.push(x);
    }

    // Method to pop the element from the front and return it
    public int pop() {
        // Swap input and output stacks
        if (output.empty()) {
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }
        }

        int x = output.peek();
        output.pop();
        
        return x;
    }

    // Get the front element of the queue
    public int peek() {
        // Swap input and output stacks
        if (output.empty())
            while (input.empty() == false) {
                output.push(input.peek());
                input.pop();
            }
        
        return output.peek();
    }
    
    // Method to get the total size of the queue
    public int size() {
        return (output.size() + input.size());
    }
    
    // Driver Code
    public static void main(String args[]) {
		
    	QueueUsingStacks ob = new QueueUsingStacks();
        
    	// Push operation
    	ob.push(4);
    	ob.push(16);
    	ob.push(25);
        ob.push(36);
        System.out.println();
    	
        // Pop operation
        System.out.println(ob.pop() + " was popped!\n");
                
        // Peek operation
        System.out.println("Top element is " + ob.peek() + "\n");
        
        // Get total size of the queue
        System.out.println("Total size of the queue is " + ob.size());

    }

}


