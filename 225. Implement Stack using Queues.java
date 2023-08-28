class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }
    
    public void push(int x) {
        // poll from q1 until it's empty and add to q2
        while(!q1.isEmpty()){
            int val1= q1.poll();
            q2.offer(val1);
        }

        // add x to q1
        q1.offer(x);
        // add back elements from q2
        while(!q2.isEmpty()){
            int val2= q2.poll();
            q1.offer(val2);
        }
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
