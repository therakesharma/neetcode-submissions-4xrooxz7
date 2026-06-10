class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder str = new StringBuilder();
        int k = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = (k * 10) + (ch - '0');
            } else if (ch == '[') {
                strStack.push(str.toString());
                numStack.push(k);
                str = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                String temp = str.toString();
                str = new StringBuilder(strStack.pop());
                str.append(temp.repeat(numStack.pop()));
            } else {
                str.append(String.valueOf(ch));
            }
        }

        return str.toString();
        
    }
}