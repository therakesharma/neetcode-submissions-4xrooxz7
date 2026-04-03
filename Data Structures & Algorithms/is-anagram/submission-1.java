class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> result = new HashMap<>();

        for (char chr : s.toCharArray()) {
            result.put(chr, result.getOrDefault(chr, 0) + 1);
        }
        for (char chr : t.toCharArray()) {
            result.put(chr, result.getOrDefault(chr, 0) - 1);
        }
        for (int num : result.values()) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
