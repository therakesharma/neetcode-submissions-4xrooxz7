class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int size : asteroids) {
            if (size > 0) {
                stack.push(size);
            } else {
                boolean flag = true;
                int top = 0;
                while (stack.size() > 0 && stack.peek() >= 0 && Math.abs(size) >= stack.peek()) {
                    top = stack.pop();
                    if (top == Math.abs(size)) {
                        flag = false;
                        break;
                    }
                }
                if (flag && (stack.size() == 0 || stack.peek() < 0)) {
                    stack.push(size);
                }
            }
        }
        int [] arr = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            arr[i] = stack.get(i);
        }
        return arr;
        
    }
}