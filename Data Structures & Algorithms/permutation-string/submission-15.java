class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int [] s1Hash = new int[26];
        for (char ch : s1.toCharArray()) {
            s1Hash[ch - 'a'] += 1;
        }

        int [] s2Hash = new int[26];
    
        for (int i = 0; i < s2.length(); i++) {
            s2Hash[s2.charAt(i) - 'a'] += 1;

            if (i + 1 >= s1.length()) {
                if (Arrays.equals(s1Hash, s2Hash)) {
                    return true;
                }
                s2Hash[s2.charAt(i + 1 - s1.length()) - 'a'] -= 1;
            }
        }

        return false;
        
    }
}