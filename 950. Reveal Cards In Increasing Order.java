class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        ArrayDeque<Integer> deque = new ArrayDeque();

        // sort the given array
        Arrays.sort(deck);

        // use a deque to
        // 1. poll from back and offer to front
        // 2. offer to front from index i ( i goes from n-1 to 0)

        int n = deck.length;
        deque.offer(deck[n-1]);

        for(int i= n-2; i >= 0; i--){
            // step 1:
            deque.offerFirst(deque.pollLast());

            // step 2:
            deque.offerFirst(deck[i]);
        }

        int[] res = new int[n];

        // convert deque to array
        int idx = 0;
        while(!deque.isEmpty()){
            res[idx++] = deque.poll();
        }

        return res;
    }
}
