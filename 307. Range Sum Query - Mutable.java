class NumArray {
    int[] segmentTree;
    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1);
    }
    
    public void update(int index, int val) {
        updateHelper(0, 0, n - 1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(0, 0, n - 1, left, right);
    }

    private void buildSegmentTree(int i, int l, int r) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }

        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1, l, mid);
        buildSegmentTree(2 * i + 2, mid + 1, r);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    private int sumRangeHelper(int i, int l, int r, int start, int end) {
        // No overlap
        if (start > r || end < l) {
            return 0;
        }

        // Full overlap
        if (start <= l && r <= end) {
            return segmentTree[i];
        }

        // Partial overlap
        int mid = l + (r - l) / 2;
        return sumRangeHelper(2 * i + 1, l, mid, start, end) +
               sumRangeHelper(2 * i + 2, mid + 1, r, start, end);
    }

    private void updateHelper(int i, int l, int r, int idx, int val) {
        if (l == r) {
            // Leaf node - value is stored here
            segmentTree[i] = val;
            return;
        }

        int mid = l + (r - l) / 2;
        
        if (idx <= mid) {
            // Update left child
            updateHelper(2 * i + 1, l, mid, idx, val);
        } else {
            // Update right child
            updateHelper(2 * i + 2, mid + 1, r, idx, val);
        }

        // Update current node
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }
}
