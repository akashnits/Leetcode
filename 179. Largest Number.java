class Solution {
    public String largestNumber(int[] nums) {
        // Convert the integers to strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort the array using a custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", then the result is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the largest number from the sorted array
        StringBuilder sb = new StringBuilder();
        for (String num : strNums) {
            sb.append(num);
        }

        return sb.toString();
    }
}
