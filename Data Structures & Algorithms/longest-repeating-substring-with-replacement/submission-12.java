class Solution {
    public int characterReplacement(String s, int k) {
        int [] sHash = new int[26];
        int left = 0, right = 0;
        int max = 0, res = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            sHash[ch - 'A'] += 1;
            max = Math.max(max, sHash[ch - 'A']);
            while ((right - left + 1 - max) > k) {
                sHash[s.charAt(left) - 'A'] -= 1;
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;

        }

        return res;
        
    }
}