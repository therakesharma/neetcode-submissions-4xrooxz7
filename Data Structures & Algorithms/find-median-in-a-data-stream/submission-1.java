class MedianFinder {
	Queue<Integer> leftHalf; 
	Queue<Integer> rightHalf; 

    public MedianFinder() {
    	leftHalf = new PriorityQueue<>((a, b) -> b - a);
    	rightHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (!rightHalf.isEmpty() && rightHalf.peek() <= num) {
        	rightHalf.add(num);
        } else {
        	leftHalf.add(num);
        }
        if (rightHalf.size() - leftHalf.size() > 1) {
        	leftHalf.add(rightHalf.poll());
        } else if (leftHalf.size() - rightHalf.size() > 1) {
        	rightHalf.add(leftHalf.poll());
        }
    }
    
    public double findMedian() {
        if (rightHalf.size() == leftHalf.size()) {
        	return (double) (rightHalf.peek() + leftHalf.peek()) / 2;
        } else if (rightHalf.size() > leftHalf.size()) {
        	return rightHalf.peek();
        } else {
        	return leftHalf.peek();
        }
    }
}
