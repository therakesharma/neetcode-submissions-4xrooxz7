class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }

        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        reverse(nums);
        
        int side = sum / k;
        if (nums[0] > side) {
            return false;
        }

        return backtrack(nums, new int[k], side, 0);

    }

    public boolean backtrack(int[] nums, int[] arr, int side, int i) {
        if (i == nums.length) {
            return true;
        }

        for (int j = 0; j < arr.length; j++) {
            boolean duplicate = false;
            for (int k = 0; k < j; k++) {
                if (arr[k] == arr[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                continue;
            }

            if (arr[j] + nums[i] <= side) {
                arr[j] += nums[i];
                if (backtrack(nums, arr, side, i + 1)) {
                    return true;
                }
                arr[j] -= nums[i];
            }
        }

        return false;

    }

    public void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}