class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (set.contains(nums[right])) {
                return true;
            }
            if (right - left >= k) {
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
        }

        return false;
        
    }
}