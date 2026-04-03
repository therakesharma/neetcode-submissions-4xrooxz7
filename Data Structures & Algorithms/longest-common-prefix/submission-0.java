class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int minLength = strs[0].length();
        for (String str : strs) {
            if (str.length() < minLength) {
                minLength = str.length();
            }
        }
        String result = "";
        for (int i = 0; i < minLength; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (ch != strs[j].charAt(i)) {
                    return result;
                }
            }
            result += ch;
        }
        return result;
    }
}