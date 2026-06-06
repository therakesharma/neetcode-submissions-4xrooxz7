class Solution {
    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        StringBuilder digit = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(digit.toString());
                digit = new StringBuilder();
                stack.push("[");
            } else if (ch == ']') {
                StringBuilder newStr = new StringBuilder();
                newStr.append(str.toString());
                str = new StringBuilder();
                while (stack.peek() != "[") {
                    newStr.insert(0, stack.pop());
                }
                stack.pop();
                int repeat = Integer.parseInt(stack.pop());
                stack.push(newStr.toString().repeat(repeat));
            } else {
                if (Character.isDigit(ch)) {
                    if (!str.isEmpty()) {
                        stack.push(str.toString());
                        str = new StringBuilder();
                    }
                    digit.append(String.valueOf(ch));
                } else {
                    str.append(String.valueOf(ch));
                }
            }
        }

        stack.push(str.toString());
        return String.join("", stack);
        
    }
}