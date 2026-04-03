class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (right > left) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public void merge(int [] arr, int left, int mid, int right) {
        int [] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[k] = arr[j];
                j++;
            } else {
                temp[k] = arr[i];
                i++;
            }
            k++;
        } 
        while ( i <= mid) { 
            temp[k] = arr[i];
            i++;
            k++;
        }
        while ( j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (int x = 0; x < temp.length; x++) {
            arr[left + x] = temp[x]; 
        }
    }


}