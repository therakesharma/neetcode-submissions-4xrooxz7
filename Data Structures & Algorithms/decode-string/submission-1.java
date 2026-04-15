class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String num = "";
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num += ch;
            } else if (ch == ']') {
                String curr = "";
                boolean isOpen = false;
                while (!stack.isEmpty()) {
                    String top = stack.pop();
                    if (top.equals("[")) {
                        isOpen = true;
                        break;
                    }
                    curr = top + curr;
                }
                String str = curr;
                if (isOpen) {
                    System.out.println(curr);
                    String value = stack.pop();
                    System.out.println(value);
                    int digit = Integer.parseInt(value);
                    System.out.println(digit);
                    for (int i = 1; i < digit; i++) {
                        str += curr;
                    }
                }
                System.out.println(str);
                stack.push(str);
            } else {
                if (!num.isEmpty()){
                    stack.push(num);
                    num = "";
                }
                stack.push(String.valueOf(ch));
            }
        }
        String res = "";
        while(!stack.isEmpty()) {
            String top = stack.pop();
            res = top + res;
        }
        return res;
    }
}