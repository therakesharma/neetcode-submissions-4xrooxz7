class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int split = average(nums, mid);
            if (split <= k) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public int average(int [] nums, int num) {
        int cap = num;
        int count = 1;
        for (int i = 0; i < nums.length;) {
            if (cap - nums[i] < 0) {
                cap = num;
                count++;
                continue;
            }
            cap -= nums[i];
            i++;
        }
        return count;
    }
}