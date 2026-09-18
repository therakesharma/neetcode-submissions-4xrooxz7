class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return sum;
    }

    public void backtrack(int index, int [] nums, List<Integer> curr) {
        if (index == nums.length) {
            sum += getXor(curr);
            return;
        }

        curr.add(nums[index]);
        backtrack(index + 1, nums, curr);

        curr.remove(Integer.valueOf(nums[index]));
        backtrack(index + 1, nums, curr);

    }

    public int getXor(List<Integer> curr) {
        if (curr.size() == 0) {
            return 0;
        }
        int xor = curr.get(0);
        for (int i = 1; i < curr.size(); i++) {
            xor ^= curr.get(i);
        }
        return xor;
    }

}