class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int index = i;
            while (!stack.empty() && heights[i] < stack.peek()[1]) {
                int[] curr = stack.pop();
                int height = curr[1];
                int width = i - curr[0];
                int area = height * width;
                result = Math.max(result, area);
                index = curr[0];
            }
            stack.push(new int[]{index, heights[i]});
        }
        while (!stack.empty()) {
            int[] curr = stack.pop();
            int area = (heights.length - curr[0]) * curr[1];
            result = Math.max(area, result);
        }
        return result;
    }
}
