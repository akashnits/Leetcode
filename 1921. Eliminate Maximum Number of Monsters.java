class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int monstersKilled = 0;
        int n = dist.length;        
        double[] time = new double[n];

        for(int i = 0; i < n; i++){
            time[i] = (double) dist[i]/speed[i];
        }

        // sort monsters as per arrival time
        Arrays.sort(time);

        for(int t=0; t < n; t++){
            // each min a monster is killed if it reaches afterwards
        
            if(time[t] <= t){
                // we can't kill this monster
                break;
            }else{
                monstersKilled++;
            }
        }
        return monstersKilled;
    }
}
