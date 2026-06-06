class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        while (right < s.length()) {
            left = Math.max(left, map.getOrDefault(s.charAt(right), 0));
            map.put(s.charAt(right), right + 1);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
