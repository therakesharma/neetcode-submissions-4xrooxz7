class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int [] tHash = new int[126];
        for (int i = 0; i < t.length(); i++) {
            tHash[t.charAt(i)] += 1;
        }
        int required = 0;
        for (int i : tHash) {
            if (i > 0) {
                required++;
            }
        }

        int [] sHash = new int[126];
        int matched = 0;
        int resL = 0, resR = -1;
        int l = 0, r = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);

            if (tHash[ch] != 0) {
                sHash[ch] += 1;
                if (tHash[ch] == sHash[ch]) {
                    matched++;
                }
            }

            while (required == matched) {
                if (resR == -1 || (resR - resL) > (r - l)) {
                    resL = l;
                    resR = r;
                }
                char ch1 = s.charAt(l);
                if (tHash[ch1] != 0) {
                    sHash[ch1] -= 1;
                    if (tHash[ch1] > sHash[ch1]) {
                        matched--;
                    }
                }
                l++;
            }
            r++;
        }

        return s.substring(resL, resR + 1);
        
    }
}