class Solution {
    public int removeElement(int[] nums, int val) {
        int result = nums.length;
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            if (num == val) {
                result -= 1;
            } else {
                arr.add(num);
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }
        return result;
    }
}