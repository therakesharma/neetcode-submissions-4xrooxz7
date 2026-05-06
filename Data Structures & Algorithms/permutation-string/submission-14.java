class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int [] s2Hash = new int[26];
        int [] s1Hash = new int[26];
        int left = 0;
        for (char ch : s1.toCharArray()) {
            s1Hash[ch - 'a'] += 1;
        }
        for (int curr = 0; curr < s2.length(); curr++) {
            s2Hash[s2.charAt(curr) - 'a'] += 1;
            if (Arrays.equals(s1Hash, s2Hash)) {
                return true;
            }
            if (curr - left + 1 == s1.length()) {
                s2Hash[s2.charAt(left) - 'a'] -= 1;
                left++;
            }
        }
        return false;
    }
}