class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack = new Stack();
        Queue<Integer> queue = new LinkedList();

        int n = sandwiches.length;

        for(int student: students){
            queue.offer(student);
        }

        for(int i=0; i < n; i++){
            stack.push(sandwiches[n-1-i]);
        }

        int lastServeDistance = 0;

        while(!stack.isEmpty()){
            
            if(queue.size() == lastServeDistance){
                // we have tried serving sandwich to all the students but none accepted
                return queue.size();
            }

            if(stack.peek() == queue.peek()){
                // eat it
                stack.pop();
                queue.poll();
                lastServeDistance = 0;
            }else {
                // poll from queue and add at the back
                int polled = queue.poll();
                queue.offer(polled);
                lastServeDistance++;
            }
        }

        return 0;
    }
}
