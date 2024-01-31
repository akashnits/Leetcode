class StockSpanner {
    List<Integer> priceList;
    Stack<Integer> stack; // maintain a monotonically decreaing stack to find next greater to the left
    int currentIdx;
    public StockSpanner() {
        stack = new Stack();
        priceList = new ArrayList();
        currentIdx = 0;
    }
    
    public int next(int price) {
        priceList.add(price);
        

        // we want to find next greater to the left
        
        while(!stack.isEmpty() && price >= priceList.get(stack.peek())){
            stack.pop();
        }

        int idx = stack.isEmpty() ? -1: stack.peek();
        int res = currentIdx - idx;
        
        // after processing, add this index to the stack
        stack.push(currentIdx++);
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
