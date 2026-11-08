class Solution {
    public boolean isAlienSorted(String[] words, String order) {
    	Map<Character, Integer> indexMap = new HashMap<>();
    	for (int i = 0; i < order.length(); i++) {
    		indexMap.put(order.charAt(i), i);
    	}
    	for (int i = 0; i < words.length; i++) {
    		if (i < 1) {
    			continue;
    		}
    		if (!isSorted(indexMap, words[i - 1], words[i])) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public boolean isSorted(Map<Character, Integer> indexMap, String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());

    	for (int i = 0; i < len; i++) {
            Integer ch1 = indexMap.get(str1.charAt(i));
            Integer ch2 = indexMap.get(str2.charAt(i));
    		
            if (ch1 > ch2) {
                return false;
            }
            if (ch1 < ch2) {
                return true;
            }
    	}
    	return str1.length() <= str2.length();
    }
}


