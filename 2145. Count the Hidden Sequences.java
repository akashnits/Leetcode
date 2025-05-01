class Solution {
    // we need to find number of hidden sequences
    // Idea: number of hidden sequences would be determined by minVal and maxValue of the sequence
    // to create sequences, we need to shift the value by k such that
    // lower <= seq[i] +k <= upper
    // Rather than each element, we can check just the max amd min value
    // maxValue + k <= upper and minValue + k >= lower
    // we need to determine k -> [ lower - minValue, upper-maxValue]
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int minVal = 0, maxVal=0, curr = 0; // we assume a[0] -> 0 , so we find a sequence ( doesn't matter valid or invalid)

        for(int d: differences){
            curr += d;
            minVal = Math.min(minVal, curr);
            maxVal = Math.max(maxVal, curr);

            // corner case: we want to avoid invalid ranges i.e. lower - minValue > upper-maxValue
            if(lower - minVal > upper-maxVal){
                return 0;
            }
        }
        // k -> [ lower - minValue, upper-maxValue]
        return (upper - maxVal) - (lower - minVal) + 1; // size of the range
    }
}
