class MinStack {
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        int min = stack.peek();
        Stack<Integer> tmp = new Stack<>();
        while (!stack.empty()) {
            min = Math.min(min, stack.peek());
            tmp.push(stack.pop());
        }
        while (!tmp.empty()) {
            stack.push(tmp.pop());
        }
        return min;
    }
}
