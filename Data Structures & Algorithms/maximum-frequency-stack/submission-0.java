class FreqStack {
    Map<Integer, Integer> elemFreq;
    Stack<Integer> freqStack;

    public FreqStack() {
        elemFreq = new HashMap<>();
        freqStack = new Stack<>();
    }
    
    public void push(int val) {
        elemFreq.put(val, elemFreq.getOrDefault(val, 0) + 1);
        freqStack.push(val);
    }
    
    public int pop() {
        int max = 0;
        for (int val : elemFreq.values()) {
            max = Math.max(max, val);
        }
        int key = -1;
        Stack<Integer> temp = new Stack<>();
        while(!freqStack.isEmpty()) {
            int curr = freqStack.pop();
            if (elemFreq.get(curr) == max) {
                elemFreq.put(curr, max - 1);
                while(!temp.isEmpty()) {
                    freqStack.push(temp.pop());
                }
                key = curr;
                break;
            } else {
                temp.push(curr);
            }
        }
        return key;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */