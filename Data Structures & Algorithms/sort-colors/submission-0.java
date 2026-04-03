class Solution {
    public void sortColors(int[] nums) {
        int k = 2;
        int [] temp = new int[k + 1];
        int [] result = new int[nums.length];
        for (int num : nums) {
            temp[num] += 1;
        }
        //System.out.println("temp -> " + Arrays.toString(temp));
        for (int i = 1; i <= k; i++) {
            temp[i] = temp[i] + temp[i - 1];
        }
        //System.out.println("temp -> " + Arrays.toString(temp));
        for (int num : nums) {
            result[temp[num] - 1] = num;
            temp[num] -= 1;
        }
        //System.out.println("temp -> " + Arrays.toString(result));
        for (int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}