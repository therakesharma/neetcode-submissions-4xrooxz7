class Solution {
    public int majorityElement(int[] nums) {
        Random rand = new Random();
        while (true) {
            int candidate = nums[rand.nextInt(nums.length)];
            int count = 0;
            for (int num : nums) {
                if (num == candidate) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return candidate;
            }
        }
    }
}