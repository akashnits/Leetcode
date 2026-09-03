class Solution {

    /* 
    Two invariants:

    Discard invariant: If starting from start makes the tank negative at i, then every station from start to i can be discarded as a possible start. So jump straight to i + 1.
    Feasibility invariant: Keep a separate running total of gas - cost across all stations and never reset it. If this total is negative, the circle is impossible; if it’s non-negative, the final candidate start is feasible.
    */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int start = 0;
        int tank = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];

            tank += diff;
            total += diff;

            // Cannot reach i + 1 from current start
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        // Overall gas is not enough to complete the circle
        if (total < 0) {
            return -1;
        }

        return start;
    }
}
