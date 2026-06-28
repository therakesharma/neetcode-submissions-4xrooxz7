class MedianFinder {
    Queue<Integer> firstHalf;
    Queue<Integer> secondHalf;
    int counter = 0;

    public MedianFinder() {
        firstHalf = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        secondHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (counter % 2 == 0) {
	        firstHalf.offer(num);
        } else {
	        secondHalf.offer(num);
        }
        if (!secondHalf.isEmpty()) {
            int first = firstHalf.peek();
            int second = secondHalf.peek();
            if (first > second) {
                firstHalf.poll();
                secondHalf.poll();
                firstHalf.offer(second);
                secondHalf.offer(first);
            }
        }
        counter++;
    }

    public double findMedian() {
	    if (counter % 2 == 0) {
		    return (double) (firstHalf.peek() + secondHalf.peek()) / 2;
        } else {
	        return firstHalf.peek();
        }
    }
}
