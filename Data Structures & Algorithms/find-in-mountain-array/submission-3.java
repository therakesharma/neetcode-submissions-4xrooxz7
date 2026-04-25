/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        int left = 0, right = len - 1, mid = 0;

        while(left <= right) {
            mid = left + (right - left) / 2;
            int leftIndex = mid == 0 ? mid : mid - 1;
            int rightIndex = mid == len - 1 ? mid : mid + 1;
            int curr = mountainArr.get(mid);
            int leftEle = mountainArr.get(leftIndex);
            int rightEle = mountainArr.get(rightIndex);

            if (curr >= rightEle && curr >= leftEle) {
                break;
            } else if (rightEle > curr) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int l = 0, r = mid;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int c = mountainArr.get(m);
            if (c == target) {
                return m;
            }
            if (target > c) {
                l = m + 1;
            } else {
                r = m -1;
            }
        }

        l = mid; r = mountainArr.length() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int c = mountainArr.get(m);
            if (c == target) {
                return m;
            }
            if (target > c) {
                r = m -1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}