/*
155. Min Stack
Medium
10.8K
711
Design a stack that supports push, pop, top, and retrieving
the minimum element in constant time.
*/

import java.util.*;

/*
class MinStack {
	private Node head;

	public void push(int val) {
		if (head == null) {
			head = new Node(val, val, null);
		} else {
			head = new Node(val, Math.min(val, head.min), head);
		}
	}

	public void pop() {
		head = head.next;
	}

	public int top() {
		return head.val;
	}

	public int getMin() {
		return head.min;
	}

	public static void main(String[] args) {
    	MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-5);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
    }
}

class Node {
	Node next;
	int val, min;
	Node(int val, int min, Node next) {
		this.val = val;
		this.min = min;
		this.next = next;
	}
}
*/

class MinStack {
	Stack<Integer> st = new Stack<Integer>();
    int stackmin = Integer.MAX_VALUE;

    public void push(int val) {
        if (val <= stackmin) {
        	st.add(stackmin);
        	stackmin = val;
        }
        st.add(val);
    }
    
    public void pop() {
        if (st.pop() == stackmin) stackmin = st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return stackmin;
    }


    public static void main(String[] args) {
    	MinStack obj = new MinStack();
		obj.push(0);
		obj.push(1);
		obj.push(0);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
    }
}