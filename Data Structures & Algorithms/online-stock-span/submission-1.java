class StockSpanner {
    Stack<List<Integer>> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (stack.size() > 0 && price >= stack.peek().get(0)) {
            span += stack.pop().get(1);
        }
        stack.push(Arrays.asList(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */