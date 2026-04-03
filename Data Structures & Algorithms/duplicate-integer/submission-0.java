class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int check : nums) {
            result.put(check, result.getOrDefault(check, 0) + 1);
        }
        Collection<Integer> values = result.values();
        for (Integer value : values) {
            if (value > 1) {
                return true;
            }
        }
        return false;
        
    }
}