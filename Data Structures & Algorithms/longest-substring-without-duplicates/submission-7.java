class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int [] arr = new int[256];
        int res = 0;
        while (right < s.length()) {
            arr[s.charAt(right)] += 1;
            while (arr[s.charAt(right)] > 1) {
                arr[s.charAt(left)] -= 1;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
