class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : hand) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);

        for (int num : hand) {

            if (freq.get(num) == 0) continue;

            int curr = num;
            int count = 0;

            // build group of size groupSize
            while (count < groupSize) {

                if (freq.getOrDefault(curr, 0) == 0) {
                    return false;
                }

                freq.put(curr, freq.get(curr) - 1);

                curr++;   // move to next consecutive
                count++;
            }
        }

        return true;
    }
}
