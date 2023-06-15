class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // find the next greater
        int idx = nextGreater(letters, 0, letters.length-1, target);
        // check to see if idx is in bounds
        if(idx > -1 && idx < letters.length){
            //check char at idx
            return letters[idx];
        }else{
            // out of bounds
            return letters[0];
        }

    }



    public int nextGreater(char[] letters, int low, int high, char target){
        if(low > high){
            return low;
        }

        int mid = low + (high-low)/2;

        if(letters[mid] <= target){
            return nextGreater(letters, mid+1, high, target);
        }else{
            return nextGreater(letters, low, mid-1, target);
        }
    }
}
