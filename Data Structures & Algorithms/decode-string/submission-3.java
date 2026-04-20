class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder num = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                if (Character.isDigit(ch)) {
                    num.append(ch);
                    continue;
                }
                if (ch == '[') {
                    stack.push(num.toString());
                    num = new StringBuilder();
                }
                stack.push(Character.toString(ch));
            } else {
                StringBuilder temp = new StringBuilder();
                while(!stack.peek().equals("[")) {
                    temp.insert(0, stack.pop());
                }
                stack.pop();
                int repeat = Integer.parseInt(stack.pop());
                stack.push(temp.toString().repeat(repeat));
            }
        }
        return String.join("", stack);
        
    }
}