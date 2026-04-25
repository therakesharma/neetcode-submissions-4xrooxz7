

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Max Heap (distance, value)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return b[0] - a[0]; // larger distance first
                return b[1] - a[1]; // if tie, larger value first
            }
        );

        for (int num : arr) {
            int[] temp = new int[]{Math.abs(num - x), num};

            if (maxHeap.size() >= k) {
                int[] top = maxHeap.peek();
                
                // if current is closer than heap top
                if (top[0] > temp[0] || 
                   (top[0] == temp[0] && top[1] > temp[1])) {
                    maxHeap.poll();
                    maxHeap.offer(temp);
                }
            } else {
                maxHeap.offer(temp);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll()[1]);
        }

        Collections.sort(result);
        return result;
    }
}