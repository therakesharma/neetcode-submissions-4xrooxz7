class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        String str = new String(chars);
        int len = str.length();
        for (int i = 0; i + len <= s2.length(); i++) {
            String sub = s2.substring(i, i + len);
            char[] chars1 = sub.toCharArray();
            Arrays.sort(chars1);
            String str1 = new String(chars1);
            if (str1.equals(str)) {
                return true;
            }

        }
        return false;
        
    }
}
