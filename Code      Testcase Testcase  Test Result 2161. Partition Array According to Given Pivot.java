class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int countSmaller = 0;
        int countGreater = 0;
        int n = nums.length;

        // First pass: count smaller and greater elements
        for (int num : nums) {
            if (num < pivot) countSmaller++;
            else if (num > pivot) countGreater++;
        }

        int[] res = new int[n];
        int l = 0;
        int mid = countSmaller;
        int r = n - countGreater;

        // Second pass: populate result array
        for (int num : nums) {
            if (num < pivot) res[l++] = num;
            else if (num > pivot) res[r++] = num;
            else res[mid++] = num;
        }
        return res;
    }
}
