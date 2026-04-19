class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] mergeArr = new int[nums1.length + nums2.length];
        int n = 0, m = 0;
        int curr = 0;
        while (n < nums1.length && m < nums2.length){
            if (nums1[n] < nums2[m]) {
                mergeArr[curr] = nums1[n];
                n++;
            } else {
                mergeArr[curr] = nums2[m];
                m++;
            }
            curr++;
        }
        while (n < nums1.length){
            mergeArr[curr] = nums1[n];
            n++;
            curr++;
        }
        while (m < nums2.length){
            mergeArr[curr] = nums2[m];
            m++;
            curr++;
        }
        
        double res = 0;
        System.out.println("res -> " + Arrays.toString(mergeArr));
        if (mergeArr.length % 2 == 0) {
            int mid = mergeArr.length / 2;
            res = (double) (mergeArr[mid] + mergeArr[mid - 1]) / 2;
        } else {
            res = mergeArr[mergeArr.length / 2];
        }
        return res;
    }
}
