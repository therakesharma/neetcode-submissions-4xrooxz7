class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            myMap.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        Stack<Double> stack = new Stack<>();
        for (int pos : position) {
            int carSpeed = myMap.get(pos);
            int distance = target - pos;
            double time = (double) distance / carSpeed;
            stack.push(time);
        }
        int result = 1;
        double peak = stack.pop();
        while (!stack.empty()) {
            if (stack.peek() <= peak) {
                stack.pop();
            } else {
                peak = stack.pop();
                result += 1;
            }

        }
        return result;
    }
}
