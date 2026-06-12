class Solution {

    Map<Integer, Integer> cache = new HashMap<>();

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        for (String str : dictionary) {
            dict.add(str);
        }
        cache.put(s.length(), 0);
        return dfs(dict, s, 0);
    }

    public int dfs(Set<String> dic, String str, int index) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        int res = 1 + dfs(dic, str, index + 1);
        for (int j = index; j < str.length(); j++) {
            if (dic.contains(str.substring(index, j + 1))) {
                res = Math.min(res, dfs(dic, str, j + 1));
            }
        }
        cache.put(index, res);
        return res;
    }
}