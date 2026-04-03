class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0, curr = 0;
            for (int j = i; j < s.length(); j++) {
                char chr = s.charAt(j);
                map.put(chr, map.getOrDefault(chr, 0) + 1);
                max = Math.max(max, map.get(chr));
                System.out.println(max);
                if ((j - i + 1 - max) > k) {
                    break;
                } else {
                    curr++;
                }
            }
            result = Math.max(result, curr);
        }
        return result;
    }
}
