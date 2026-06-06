class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int lIndex = 0, rIndex = -1;
        int left = 0, right = 0;
        int have = 0, required = tMap.size();

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (tMap.containsKey(ch)) {
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

                if (tMap.get(ch).intValue() == sMap.get(ch).intValue()) {
                    have++;
                }
            }
        

            while (have == required) {

                if (rIndex == -1 || (right - left < rIndex - lIndex)) {
                    lIndex = left; 
                    rIndex = right;
                }

                char last = s.charAt(left);

                if (tMap.containsKey(last)) {
                    sMap.put(last, sMap.get(last) - 1);

                    if (sMap.get(last).intValue() < tMap.get(last).intValue()) {
                        have--;
                    }
                }

                left++;

            }
            right++;
        }

        return s.substring(lIndex, rIndex + 1);

    }

}