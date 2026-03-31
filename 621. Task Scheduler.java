class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFreq = 0;
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
        }
        
        int countMax = 0;

        // count how many tasks have max frequency
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) countMax++;
        }

        // A _ _ | A _ _ | A 
        // A is the most frequent; part length is 3 since n ==2; partCount is maxFreq-1
        // why countMax si added ? (partCount * partLength) doesn't include the last block
        // last block is equals number of elements having max frequency
        int partCount = maxFreq - 1; 
        int partLength = n + 1;
        int minTime = partCount * partLength + countMax;

        return Math.max(tasks.length, minTime);
    }
}
