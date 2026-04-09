class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            char [] chars = str.toCharArray();
            int [] freq = new int[26];
            for (char ch : chars) {
                freq[ch - 'a']++;
            }
            String newStr = Arrays.toString(freq);
            List<String> list = resMap.getOrDefault(newStr, new ArrayList<>());
            list.add(str);
            resMap.put(newStr, list);
        }
        return new ArrayList<>(resMap.values());
    }
}
