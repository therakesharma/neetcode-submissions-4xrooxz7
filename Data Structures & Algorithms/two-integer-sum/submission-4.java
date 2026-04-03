class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            result.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (result.containsKey(diff) && i != result.get(diff)){
                return new int[]{i, result.get(diff)};
            }
        }
        return new int[0];
    }
}
