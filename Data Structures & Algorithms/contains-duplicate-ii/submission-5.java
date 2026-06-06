class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            if (window.size() == k + 1) {
                window.remove(nums[left]);
                left++;
            }
            if (window.contains(nums[right])) {
                return true;
            }
            window.add(nums[right]);
            right++;
        }
        return false;
    }
}