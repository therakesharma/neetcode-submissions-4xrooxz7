class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }
        int [] temp = new int[m + n];
        int a = 0, b = m, k = 0;
        while (a < m && b < m + n) {
            if (nums1[a] < nums1[b]) {
                temp[k] = nums1[a];
                a++;
            } else {
                temp[k] = nums1[b];
                b++;
            }
            k++;
        }
        while (a < m) {
            temp[k] = nums1[a];
            a++;
            k++;
        }
        while (b < m + n) {
            temp[k] = nums1[b];
            b++;
            k++;
        }
        for (int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }
    }
}