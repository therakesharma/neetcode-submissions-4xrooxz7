class MyCircularQueue {
    int [] queue;
    int front = 0, rear = -1, count = 0, capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        count += 1;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        queue[front] = -1;
        front = (front + 1) % capacity;
        count -= 1;
        return true;      
    }
    
    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }
    
    public int Rear() {
        return isEmpty() ? -1: queue[rear];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == capacity;
    }
}