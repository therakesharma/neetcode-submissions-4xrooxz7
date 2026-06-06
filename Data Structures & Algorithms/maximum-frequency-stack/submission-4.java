class FreqStack {
    int maxFreq;
    Map<Integer, Integer> elemFreqMap;
    Map<Integer, Stack<Integer>> freqStackMap;

    public FreqStack() {
        maxFreq = 0;
        elemFreqMap = new HashMap<>();
        freqStackMap = new HashMap<>();
    }
    
    public void push(int val) {
        int currFreq = elemFreqMap.getOrDefault(val, 0);
        elemFreqMap.put(val, currFreq + 1);
        Stack<Integer> currStack = freqStackMap.getOrDefault(currFreq + 1, new Stack<>());
        currStack.push(val);
        freqStackMap.put(currFreq + 1, currStack);
        maxFreq = Math.max(currFreq + 1, maxFreq);
    }
    
    public int pop() {
        Stack<Integer> currStack = freqStackMap.get(maxFreq);

        int val = currStack.pop();
        elemFreqMap.put(val, elemFreqMap.get(val) - 1);
        if (currStack.isEmpty()) {
            maxFreq--;
        }
        return val; 
    }
}
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */