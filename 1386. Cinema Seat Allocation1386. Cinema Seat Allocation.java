class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // choices
        List<int[]> choices = new ArrayList();
        choices.add(new int[] { 2, 3, 4, 5 });
        choices.add(new int[] { 4, 5, 6, 7 });
        choices.add(new int[] { 6, 7, 8, 9 });

        int m = reservedSeats.length;

        Map<Integer, Set<Integer>> seatMap = new HashMap();
        // map contains row (1-indexed) -> reservedSeatNumbers

        for (int[] seat : reservedSeats) {
            seatMap.putIfAbsent(seat[0], new HashSet());
            Set<Integer> set = seatMap.get(seat[0]);
            set.add(seat[1]);
        }

        // every row that has no reserved seats can fit 2 families.
        // directly count those rows instead of iterating through all n rows.
        int count = (n - seatMap.size()) * 2;

        // only iterate over rows which have at least one reserved seat.
        for (int r : seatMap.keySet()) {
            Set<Integer> reserved = seatMap.get(r);

            boolean left = canAllocate(choices.get(0), reserved);
            boolean middle = canAllocate(choices.get(1), reserved);
            boolean right = canAllocate(choices.get(2), reserved);

            // left and right don't overlap, so we can fit 2 families
            if (left && right) {
                count += 2;
            }
            // otherwise, if any one block is available, we can fit 1 family
            else if (left || middle || right) {
                count++;
            }
        }

        return count;
    }

    boolean canAllocate(int[] choice, Set<Integer> reservedSeats) {
        for (int c : choice) {
            // if any required seat is reserved,
            // this choice cannot be allocated
            if (reservedSeats.contains(c))
                return false;
        }
        return true;
    }
}
