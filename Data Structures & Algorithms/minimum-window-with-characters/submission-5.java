class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int lIndex = 0, rIndex = -1, left = 0, matched = 0, required = tMap.size();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (tMap.containsKey(ch)) {
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

                if (sMap.get(ch).intValue() == tMap.get(ch).intValue()) {
                    matched++;
                }
            }

            while (matched >= required) {
                char ch1 = s.charAt(left);
                if (rIndex == -1 || (rIndex - lIndex >= right - left)) {
                    rIndex = right;
                    lIndex = left;
                }
                if (tMap.containsKey(ch1)) {
                    sMap.put(ch1, sMap.getOrDefault(ch1, 0) - 1);
                    if (sMap.get(ch1).intValue() < tMap.get(ch1).intValue()) {
                        matched--;
                    }
                }
                left++;
            }
        }

        return s.substring(lIndex, rIndex + 1);
        
    }
}