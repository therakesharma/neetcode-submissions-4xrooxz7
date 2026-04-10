class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        char [] chars = s.toCharArray();
        while ( l < r) {
            if (chars[l] != chars[r]) {
                return isPalindrome(s, l, r - 1) || isPalindrome(s, l + 1, r);
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        char [] chars = s.toCharArray();
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}