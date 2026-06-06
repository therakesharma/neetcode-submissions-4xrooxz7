class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Use fixed arrays instead of HashMaps for O(1) lookups
        int[] targetCounts = new int[128];
        int[] windowCounts = new int[128];

        for (int i = 0; i < t.length(); i++) {
            targetCounts[t.charAt(i)]++;
        }

        int required = 0;
        for (int count : targetCounts) {
            if (count > 0) required++;
        }

        int left = 0, matched = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;

        // Sliding window
        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            windowCounts[rChar]++;

            if (targetCounts[rChar] > 0 && windowCounts[rChar] == targetCounts[rChar]) {
                matched++;
            }

            // Shrink window
            while (matched == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                char lChar = s.charAt(left);
                windowCounts[lChar]--;

                if (targetCounts[lChar] > 0 && windowCounts[lChar] < targetCounts[lChar]) {
                    matched--;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
