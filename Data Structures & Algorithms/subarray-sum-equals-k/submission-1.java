class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int diff = sum - k;
            if (prefixSum.containsKey(diff)) {
                res += prefixSum.get(diff);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return res;        
    }
}