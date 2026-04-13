class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : operations) {
            if (s.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                res += newTop;
            } else if (s.equals("D")) {
                int num = stack.peek() * 2;
                stack.push(num);
                res += num;
            } else if (s.equals("C")) {
                int num = stack.pop();
                res -= num;
            } else {
                stack.push(Integer.parseInt(s));
                res += stack.peek();
            }
        }
        return res;
    }
}