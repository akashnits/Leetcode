class Solution {
    // O(n * log(maxGap * 1e-6))
    public double minmaxGasDist(int[] stations, int k) {
        int n = stations.length;

        double l = 0;
        double r = 0;

        // upper bound = maximum adjacent gap
        for (int i = 0; i < n - 1; i++) {
            r = Math.max(r, stations[i + 1] - stations[i]);
        }

        // binary search on answer
        while (r - l >= 1e-6) {
            double mid = l + (r - l) / 2;

            if (canPlace(stations, k, mid)) {
                // mid works, try smaller max distance
                r = mid;
            } else {
                // mid is too small
                l = mid;
            }
        }
        return r;
    }


    boolean canPlace(int[] stations, int k, double maxDist) {
        int needed = 0;

        for (int i = 0; i < stations.length - 1; i++) {
            double gap = stations[i + 1] - stations[i];

            // number of new stations needed so every piece <= maxDist
            needed += (int) Math.ceil(gap / maxDist) - 1;

            if (needed > k) {
                return false;
            }
        }

        return true;
    }



    // using heap - times out as K is large O(n + klog(n))
    double approach1(int[] stations, int k){
        PriorityQueue<Pair<Integer, Integer>> maxHeap =
            new PriorityQueue<>((a, b) ->
                Double.compare(
                    (double) b.getKey() / b.getValue(),
                    (double) a.getKey() / a.getValue()
                )
            );

        int n = stations.length;

        for (int i = 0; i < n - 1; i++) {
            int diff = stations[i + 1] - stations[i];

            // value = number of segments currently in this gap
            Pair<Integer, Integer> p = new Pair<>(diff, 1);
            maxHeap.offer(p);
        }

        while (k-- > 0) {
            Pair<Integer, Integer> popped = maxHeap.poll();

            int count = popped.getValue() + 1;

            maxHeap.offer(
                new Pair<>(popped.getKey(), count)
            );
        }

        Pair<Integer, Integer> top = maxHeap.peek();

        return (double) top.getKey() / top.getValue();
    }
}
