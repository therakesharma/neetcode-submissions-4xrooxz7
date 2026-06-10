class Solution {
    int i = 0;
    public String decodeString(String s) {
        return helper(s);
    }

    public String helper(String s) {
        StringBuilder str = new StringBuilder();
        int repeat = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            i++;
            if (Character.isDigit(ch)) {
                repeat = (repeat * 10) + (ch - '0');
            } else if (ch == '[') {
                String subStr = helper(s);
                while (repeat > 0) {
                    str.append(subStr);
                    repeat--;
                }
                continue;
            } else if (ch == ']') {
                break;
            } else {
                str.append(String.valueOf(ch));
            }
            
        }

        return str.toString();
    }
}