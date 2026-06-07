class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // if (arr.length == k) {
        //     return Arrays.asList(arr);
        // }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += Math.abs(arr[i] - x);
        }

        int left = 0, right = k;
        while (right < arr.length) {
            int newSum = sum - Math.abs(arr[right - k] - x) + Math.abs(arr[right] - x);
            if (sum > newSum) {
                sum = newSum;
                left = right - k + 1;
            }
            right++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }

        return res;
        
    }
}