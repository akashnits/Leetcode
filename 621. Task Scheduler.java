class Solution {
    public int leastInterval(char[] tasks, int n) {
        // we need to process tasks with max freq first to avoid idle time later
        // use priority queue to keep max frequency at the top

        // create a freq arr
        int[] freq = new int[26];
        for(char task: tasks){
            freq[task - 'A']++;
        }

        // maxHeap based on frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));

        for(int f: freq){
            if(f > 0){
                maxHeap.offer(f);
            }
        }

        int waitTime = 0; 

        while(!maxHeap.isEmpty()){
            // keep track of freq of tasks picked in this cycle
            List<Integer> freqList = new ArrayList();
            // we need to pick n+1 tasks if possible
            for(int i=0; i < n+1; i++){
                if(maxHeap.isEmpty()){
                    break;
                }else{
                    // process task, we pop from maxHeap and keep track
                    freqList.add(maxHeap.poll()-1);
                }
            }

            // loop through freqList and add back to maxHeap if freq > 0
            for(int ele: freqList){
                if(ele > 0){
                    maxHeap.offer(ele);
                }
            }

            // check if we have tasks to be completed ?
            if(!maxHeap.isEmpty()){
                waitTime += n+1; // includes idle time
            }else{
                waitTime += freqList.size();
            }
            
        }

        return waitTime;
    }
}
