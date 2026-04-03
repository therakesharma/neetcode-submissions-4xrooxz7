class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        boolean isInclusion = false;
        HashMap<Character, Integer> s1Map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : s1Map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            HashMap<Character, Integer> s2Map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                s2Map.put(s2.charAt(i + j), s2Map.getOrDefault(s2.charAt(i + j), 0) + 1);
            }
            System.out.println("start");
            for (Map.Entry<Character, Integer> entry : s2Map.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
            boolean allMatched = true;
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (s1Map.getOrDefault(ch, 0) != s2Map.getOrDefault(ch, 0)) {
                    allMatched = false;
                }
            }
            System.out.println("output" + allMatched);
            if (allMatched) {
                isInclusion = true;
                break;
            }
        }
        return isInclusion;
    }
}
