class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            maxPQ.offer(stone);
        }

        while (maxPQ.size() > 1) {
            int first = maxPQ.poll();
            int second = maxPQ.poll();
            maxPQ.offer(first - second);
        }

        return maxPQ.poll();
        
    }
}
