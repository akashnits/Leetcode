class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int length = arr.length;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;

        for (int num : arr) {
            first = Math.min(first, num);
            last = Math.max(last, num);
        }

        if(last - first == 0){
            // all elements are same
            return true;
        }

        // if the first and last aren't same, it means we can't have duplicate elements
        // keeping track of duplicate elemnets using a set

        double diff = (double) (last - first) / (length - 1);
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            // arr[i] - firstValue must be a multiple of diff in AP
            if((arr[i] - first) % diff != 0){
                return false;
            }

            numberSet.add(arr[i]);
        }

        return numberSet.size() == length;
    }

        
}
