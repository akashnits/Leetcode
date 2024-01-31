class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // find the next greater element in circular array
        // algo remain as is except that we traverse the array twice

        int n = nums.length;
        Stack<Integer> stack = new Stack();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for(int i=0; i < 2*n; i++){
            // we check if incoming element is greater than stack top
            while(!stack.isEmpty() && nums[i % n] > nums[stack.peek()]){
                // yes - pop as it's next greater element
                int idx = stack.pop();
                ans[idx] = nums[i % n];
            }
            stack.push(i % n); // we push  this index to find it's greater
        }
        return ans;
    }
}
