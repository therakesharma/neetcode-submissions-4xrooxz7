public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int [] s1Hash = new int[26];
        int [] s2Hash = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Hash[s1.charAt(i) - 'a'] += 1;
            s2Hash[s2.charAt(i) - 'a'] += 1;
        }

        if (Arrays.equals(s1Hash, s2Hash)) {
            return true;
        }

        int left = 0;
        int right = s1.length();

        while(right < s2.length()) {
            s2Hash[s2.charAt(right) - 'a'] += 1;
            s2Hash[s2.charAt(left) - 'a'] -= 1;

            if (Arrays.equals(s1Hash, s2Hash)) {
                return true;
            }
            right++;
            left++;
        }


        return false;
    }
}