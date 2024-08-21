class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        // Initialize the index of the best sightseeing spot seen so far
        int bestSightSeeingIdx  = 0;
        int n = values.length;
        int maxScore = 0;

        for(int i = 1; i < n; i++){
            // Calculate maxScore using current index and bestSightSeeingIdx till now
            int score = values[bestSightSeeingIdx] + values[i] + bestSightSeeingIdx - i;
            maxScore = Math.max(maxScore, score);

            // Update the best sightseeing spot if the current one is better
            if (values[i] + i > values[bestSightSeeingIdx] + bestSightSeeingIdx) {
                bestSightSeeingIdx = i;
            }
        }

        return maxScore;
    }
}
