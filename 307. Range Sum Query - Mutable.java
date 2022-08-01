class NumArray {

    int[] segTree;
    int[] input;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        input = nums;
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        segTree = new int[max_size];
        
        construct(0, 0, n-1);
    }
    
    // traverse segment tree and figure out the range which contains the update index
    // add diff to it
    public void update(int index, int val) {
        int diff = val - input[index];
        input[index] = val;
        updateHelper(0, n-1, 0, index, diff);
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(0, n-1, left, right, 0);
    }
    
    int  sumRangeHelper(int start, int end, int left, int right , int i){
       
        //  base condition 
        
        // invalid
        if(start > right || end < left){
            return 0;
        }
        
        if (left <= start && right >= end)
            return segTree[i];
        
        int mid = start + (end - start)/2;
        
        return sumRangeHelper(start, mid, left, right, 2*i+1) + 
            sumRangeHelper(mid+1, end, left, right, 2*i+2);
    }
    
    void updateHelper(int start, int end, int i, int index, int diff){
        if(index < start || index > end){
            // not in range
            return;
        }
        
        segTree[i] += diff;
        
        if( start == end ){
            return;
        }
        
        int mid = start + (end - start)/2;
        updateHelper(start, mid, 2*i+1, index, diff);
        updateHelper(mid+1, end, 2*i+2, index, diff);
        return;
    }
    
    int construct(int i , int start , int end){
        // base condition
        if(start == end){
            segTree[i] = input[start];
            return segTree[i];
        }
        
        int mid = start + (end- start)/2;
        
        segTree[i] = construct(2*i+1, start, mid) + construct(2*i+2, mid+1, end);
        return segTree[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
