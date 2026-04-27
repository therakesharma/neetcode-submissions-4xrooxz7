class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int [] s1Hash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Hash[s1.charAt(i) - 'a'] += 1;
        }
        int [] s2Hash = new int[26];
        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            s2Hash[s2.charAt(r) - 'a'] += 1;
            if (r  >= s1.length()) {
                s2Hash[s2.charAt(l) - 'a'] -= 1;
                l++;
            }

            boolean found = true;
            for (int i = 0; i < 26; i++) {
                if (s1Hash[i] != s2Hash[i]) {
                    found = false;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }
}