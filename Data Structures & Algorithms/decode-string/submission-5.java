class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(String.valueOf(ch));
            } else {
                StringBuilder str = new StringBuilder();
                while(!stack.peek().equals("[")) {
                    str.insert(0, stack.pop());
                }

                stack.pop();

                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    num.insert(0, stack.pop());
                }

                String subStr = str.toString();
                int count = Integer.parseInt(num.toString());

                stack.push(subStr.repeat(count));
                
            }
        }

        return String.join("", stack);
    }
}