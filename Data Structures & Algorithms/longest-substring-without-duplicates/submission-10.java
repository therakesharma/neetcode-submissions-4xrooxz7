class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = -1, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        while (right < s.length()) {
            left = Math.max(left, map.getOrDefault(s.charAt(right), -1));
            map.put(s.charAt(right), right);
            res = Math.max(res, right - left);
            right++;
        }
        return res;
    }
}
