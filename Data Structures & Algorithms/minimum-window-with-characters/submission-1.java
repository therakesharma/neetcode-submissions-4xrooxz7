class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char ch: t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= s.length() - i - t.length(); j++){
                HashMap<Character, Integer> sMap = new HashMap<>();
                String subStr = s.substring(j, j + i + t.length());
                for (char ch : subStr.toCharArray()) {
                    sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                }
                boolean found = true;
                for (char ch : tMap.keySet()) {
                    if(sMap.getOrDefault(ch, 0) < tMap.getOrDefault(ch, 0)) {
                        found = false;
                    }
                }
                if (found && (str.length() == 0 || str.length() > subStr.length())) {
                    str = subStr;
                } 
            }
        }
        return str;
    }
}
