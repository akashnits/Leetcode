class Solution {
    public int findKthLargest(int[] nums, int k) {
       return quickSelect(nums, k, 0, nums.length-1);
    }

    // approach 1: using minHeap

    int usingMinHeap(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a-b);

        // maintain a minheap of size k and store the largest k elements

        for(int num: nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    // approach 2: using quick select (similar to quick sort idea)

    int quickSelect(int[] nums, int k, int start, int end){
        // we select a pivot
        int pivot = start;
        // we select left and right
        int left = start+1;
        int right = end;

        // idea is to find the correct position of pivot element i.e. all elements to the left <= nums[pivot]
        // all element to the right > nums[pivot]

        while(left <= right){
            // case 1: check if both left and right are out pf place ? - swap
            if(nums[pivot] < nums[left] && nums[pivot] > nums[right]){
                swap(nums, left, right);
                left++;
                right--;
            }
            // case 2: if left is already sorted
            if(nums[left] <= nums[pivot]){
                left++;
            }

            // case 3: if right os already sorted
            if(nums[right] >= nums[pivot]){
                right--;
            }
        }

        // check if right is kth largest
        if(right == nums.length -k){
            // we have found the element
            return nums[pivot];
        }

        // we swap right with pivot so that pivot is at it's right place
        swap(nums, pivot, right);

        // we have two options - to check left subarray or right subarray
        if(nums.length - right < k){
            // check left subarray
            return quickSelect(nums, k, start, right-1);
        }else{
            return quickSelect(nums, k, right+1, end);
        }

    }

    void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
