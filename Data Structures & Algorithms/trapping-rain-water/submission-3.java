class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int rMax = height[i], lMax = height[j], result = 0;
        while (i < j) {
            if (rMax < lMax) {
                i++;
                rMax = Math.max(rMax, height[i]);
                result += (rMax - height[i]);
            } else {
                j--;
                lMax = Math.max(lMax, height[j]);
                result += (lMax - height[j]);
            }
        }
        return result;
    }
}
