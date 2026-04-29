class FreqStack {
    int maxFreq;
    List<Stack<Integer>> freqs;
    Map<Integer, Integer> eleFreq;

    public FreqStack() {
        maxFreq = 0;
        freqs = new ArrayList<>();
        freqs.add(new Stack());
        eleFreq = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = eleFreq.getOrDefault(val, 0) + 1;
        eleFreq.put(val, freq);

        if (freq == freqs.size()) {
            freqs.add(new Stack());
        }

        System.out.println("size -> " + freqs.size());
        System.out.println("freq -> " + freq);

        freqs.get(freq).add(val);
        maxFreq = Math.max(freq, maxFreq);
    }
    
    public int pop() {
        Stack<Integer> stack = freqs.get(maxFreq);
        int res = stack.pop();
        if (stack.isEmpty()) {
            maxFreq -= 1;
        }
        eleFreq.put(res, eleFreq.get(res) - 1);
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */