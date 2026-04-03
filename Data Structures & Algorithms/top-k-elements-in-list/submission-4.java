class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int num : nums) {
            resultMap.put(num, resultMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(resultMap.values());
        List<Integer> keys = new ArrayList<>(resultMap.keySet());
        values.sort(Comparator.reverseOrder());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < keys.size(); j++) {
                if (resultMap.get(keys.get(j)) ==  values.get(i)) {
                    arr[i] = keys.get(j);
                    keys.remove(j);
                    break;
                }
            }
        }
        return arr;
    }
}
