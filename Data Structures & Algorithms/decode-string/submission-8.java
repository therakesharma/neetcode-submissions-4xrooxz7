class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (ch != ']') {
                stack.push(String.valueOf(ch));
            } else {
                StringBuilder str = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    str.insert(0, stack.pop());
                }
                stack.pop();
                StringBuilder numStr = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    numStr.insert(0, stack.pop());
                }
                int num = Integer.parseInt(numStr.toString());
                //stack.push(String.repeat(num, str.toString()));
                stack.push(str.toString().repeat(num));
            }
        }

        return String.join("", stack);
        
    }
}