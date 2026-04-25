class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;

        for (int right = 0; right < s.length(); right++) {
            left = Math.max(map.getOrDefault(s.charAt(right), 0), left);
            map.put(s.charAt(right), right + 1);
            res = Math.max(res, (right - left + 1));
        }

        return res;
    }
}