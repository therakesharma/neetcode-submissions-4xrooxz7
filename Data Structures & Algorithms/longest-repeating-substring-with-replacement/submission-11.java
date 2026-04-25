class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, l = 0, max = 0;
        int [] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'A' ] += 1;
            max = Math.max(max, freq[s.charAt(i) - 'A']);
            while(i - l + 1 - max > k) {
                freq[s.charAt(l) - 'A'] -= 1;
                l++;
            }
            res = Math.max(res, (i - l + 1));
        }
        return res;
    }
}