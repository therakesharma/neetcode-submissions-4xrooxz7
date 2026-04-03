class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int num : nums) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
        int num = 0, count = 0;
        for (int key : result.keySet()) {
            if (result.get(key) > count) {
                num = key;
                count = result.get(key);
            }
        }
        return num;
    }
}