class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                right--;
            } else {
                left++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
        
    }
}