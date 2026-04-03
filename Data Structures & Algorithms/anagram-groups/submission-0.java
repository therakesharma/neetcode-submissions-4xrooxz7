class Solution {
    public String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            String sortStr = sortString(str);
            if (result.containsKey(sortStr)) {
                List<String> list = result.get(sortStr);
                list.add(str);
                result.put(sortStr, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                result.put(sortStr, list);
            }
        }
        return new ArrayList<>(result.values());
    }
}
