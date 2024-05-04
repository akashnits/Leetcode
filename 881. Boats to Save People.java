// Approach1 -> Sorting: TC -> O(nlogn), SC -> O(1)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // sort the people array as per weight
        Arrays.sort(people);

        // we try to accomodate 1 heavy + 1 light weight person on the boat
        int n = people.length;
        int start = 0, end = n-1;

        int numberBoats = 0;
        while(start <= end){
            // we pick a heavy person and put on the boat
            // check if we have capacity remaining for light weight person
            int heavyMan = people[end--];
            if(start <= end && limit - heavyMan >= people[start]){
                // accomodate him and sail
                start++;
            }
            numberBoats++;
        }
        return numberBoats;
    }
}
// Approach2 -> Bucket sort: TC -> O(n), SC -> O(limit+1)
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] buckets = new int[limit+1];
        for(int p: people) {
            buckets[p]++; // stores the freq for same weight people at index p
        }
        int start = 0;
        int end = buckets.length - 1;
        int boats = 0;
        while(start <= end) {
			      //no person at start, freq less than equals 0
            while(start <= end && buckets[start] <= 0) start++;
			      //no person at end, freq less than equals 0
            while(start <= end && buckets[end] <= 0) end--;
			      //no one else left on the ship, hence break.
            if(buckets[start] <= 0 && buckets[end] <= 0) break;

            boats++;
            if(start + end <= limit){
                // can accomodate both
                buckets[start]--;
                buckets[end]--;
            }else{
                //accomodate heavy person only
                buckets[end]--;
            }
        }
        return boats;
    }
}
