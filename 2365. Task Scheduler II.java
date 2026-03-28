class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        // sweep approach: keep the clock ticking and execute as we find suitable
        Map<Integer, Long> map = new HashMap();
        int n = tasks.length;

        int i =0; long timeElapsed = 0;
        while(i < n){
            // decide if we can execute the task at i or wait ?
            if(map.containsKey(tasks[i]) && map.get(tasks[i]) > timeElapsed){
                // we must wait for a period
                timeElapsed = map.get(tasks[i]);
                continue;
            }

            // we can execute here
            // set cooldown for this task
            long nextAvailableAt = timeElapsed+space+1;
            map.put(tasks[i], nextAvailableAt);
            i++;
            timeElapsed++;
        }
        return timeElapsed;
    }
}
