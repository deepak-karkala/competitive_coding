/*
155. Min Stack
Solved
Medium
Topics
Companies
Hint
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
*/

class MinStack {
    Stack<Integer> st;
    int min;

    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (val <= min) {
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if (st.pop() == min) min = st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}
