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
        if (len < 3) {
            return -1;
        }
        int left = 0, right = len - 1;
        int high = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midElement = mountainArr.get(mid);

            int leftIndex = mid - 1;
            int rightIndex = mid + 1;

            int rightElement = mountainArr.get(rightIndex);
            int leftElement = mountainArr.get(leftIndex);

            if (midElement > leftElement && midElement > rightElement) {
                high = mid;
                break;
            } else if (midElement < leftElement) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("highest index -> " + high);

        left = 0; right = len - 1;
        int tempRight = high;
        while (left <= tempRight) {
            int mid = left + (tempRight - left) / 2;
            int midElement = mountainArr.get(mid);

            if (midElement == target) {
                return mid;
            }

            if (target > midElement) {
                left = mid + 1;
            } else {
                tempRight = mid - 1;
            }
        }

        int tempLeft = high;
        while (tempLeft <= right) {
            int mid = tempLeft + (right - tempLeft) / 2;
            int midElement = mountainArr.get(mid);

            if (midElement == target) {
                return mid;
            }

            if (target > midElement) {
                right = mid - 1;
            } else {
                tempLeft = mid + 1;
            }
        }

        return -1;
    }
}