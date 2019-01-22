import java.util.Stack;


public class MinStack {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
/*		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
*/		System.out.println(minStack.getMin());   //--> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   //--> Returns -2.	
	}
	
	Stack<Integer> stack;
	int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    // push null to indicate it's minimum. Also push previous min for pop
    public void push(int x) {
    	if (x<min) {    		
    		stack.push(min);
    		stack.push(null);
    		min=x;
    	}
    	stack.push(x);
    }
    
    public void pop() {
    	if (!stack.isEmpty()) {
    		stack.pop();    		
    		if (stack.peek()==null) {
    			stack.pop();
    			min = stack.pop();
    		}
    	}
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
    	return min;        
    }
}
