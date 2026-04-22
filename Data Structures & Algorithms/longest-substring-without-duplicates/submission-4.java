class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> orderedSet = new LinkedHashSet<>();
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (orderedSet.contains(ch)) {
                Iterator<Character> it = orderedSet.iterator();
                while(it.hasNext()) {
                    char curr = it.next();
                    it.remove();
                    if (curr == ch) {
                        break;
                    }
                }
            }
            orderedSet.add(ch);
            res = Math.max(res, orderedSet.size());
        }
        return res;
    }
}
