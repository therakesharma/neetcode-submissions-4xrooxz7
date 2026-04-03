class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder();
            int len = 0;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                //System.out.println(str.indexOf(String.valueOf(ch)));
                if (str.indexOf(String.valueOf(ch)) != -1) {
                    break;
                }
                str.append(ch);
                len++;
            }
            result = Math.max(result, len);
        }
        return result;
    }
}
