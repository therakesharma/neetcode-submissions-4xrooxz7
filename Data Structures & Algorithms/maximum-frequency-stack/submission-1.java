class FreqStack {
    Map<Integer, Integer> elemFreq;
    Map<Integer, Stack<Integer>> freqStack;
    int maxFreq = 0;

    public FreqStack() {
        elemFreq = new HashMap<>();
        freqStack = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = elemFreq.getOrDefault(val, 0) + 1;
        elemFreq.put(val,  freq);
        maxFreq = Math.max(maxFreq, freq);
        Stack<Integer> stack = freqStack.getOrDefault(freq, new Stack<>());
        stack.push(val);
        freqStack.put(freq, stack);
    }
    
    public int pop() {
        System.out.println("max -> " + maxFreq);
        Stack<Integer> stack = freqStack.get(maxFreq);
        System.out.println("stack -> " + stack.toString());
        int res = stack.pop();
        if (stack.isEmpty()) {
            maxFreq -= 1;
        }
        elemFreq.put(res, elemFreq.get(res) - 1);
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */