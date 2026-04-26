class Solution {
    public int lengthOfLastWord(String s) {
        String [] arr = s.split(" ");
        String res = "";
        for (String str : arr) {
            if (!str.isEmpty()) {
                res = str;
            }
        }
        return res.length();
    }
}