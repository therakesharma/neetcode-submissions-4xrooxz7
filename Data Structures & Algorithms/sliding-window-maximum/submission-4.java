class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = k;
        List<Integer> list = new ArrayList<>();
        while (right <= nums.length) {
            int max = Arrays.stream(Arrays.copyOfRange(nums, left, right)).max().getAsInt();
            list.add(max);
            right++;
            left++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
