class Solution {
    public boolean isAlienSorted(String[] words, String order) {
    	Map<Character, Integer> indexMap = new HashMap<>();
    	for (int i = 0; i < order.length(); i++) {
    		indexMap.put(order.charAt(i), i);
    	}
    	
    	for (int i = 1; i < words.length; i++) {
    		String word1 = words[i - 1];
    		String word2 = words[i];
    		
    		if (!isSorted(indexMap, word1, word2)) {
    			return false;
    		}
    		
    	}
    	return true;
    }
    
    public boolean isSorted(Map<Character, Integer> wordIndex, String str1, String str2) {
    	Integer len = Math.min(str1.length(), str2.length());
    	
    	for (int i = 0; i < len; i++) {
    		int index1 = wordIndex.get(str1.charAt(i));
    		int index2 = wordIndex.get(str2.charAt(i));
    		
    		if (index1 > index2) {
    			return false;
    		}
    		if (index1 < index2) {
    			return true;
    		}
    	}
    	
    	return str1.length() <= str2.length();
    }
}