class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stations[i];
        }
        
        // intial power at each i
        long[] power = new long[n];
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right + 1] - prefix[left];
        }

        long total=0;
        for(int station: stations){
            total += station;
        }
        total += k;
        
        long left = 0, right = total;
        
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            
            if (canAchieve(power, r, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    private boolean canAchieve(long[] power, int r, int k, long target) {
        int n = power.length;
        long[] addedStations = new long[n]; // keep tracks if station we added at i
        long influenceFromPrevAdded = 0; // influence of previously added station at i
        long powerLeft = k;
        
        for (int i = 0; i < n; i++) {
            // influence over for station which is far away i-r-1 distance away
            // it could only reach i+r or i-r
            if (i > r) {
                influenceFromPrevAdded -= addedStations[i - r - 1];
            }
            
            long currPower = power[i] + influenceFromPrevAdded;
            if (currPower < target) {
                long powerNeeded = target - currPower;
                if (powerNeeded > powerLeft) return false;
                
                int pos = Math.min(n - 1, i + r); // add at farthest point greedy 
                addedStations[pos] += powerNeeded;
                influenceFromPrevAdded += powerNeeded;
                powerLeft -= powerNeeded;
            }
        }
        
        return true;
    }
}
