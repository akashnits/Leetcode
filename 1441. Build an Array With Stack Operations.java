class Solution {
    // Approach: Push the incoming elemen and con=mpare with target element
    // if it matches - move on
    // if not - pop it
    // do this until no more element in target or no more ele in the stream
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList();
        int i = 1; // index for elements in the stream
        int j = 0; // index of elements in target

        while( i <= n && j < target.length){
            // push the element
            res.add("Push");

            // compare
            if( i == target[j]){
                // elements matched, find next target element now
                j++;
                if(j == target.length)
                    return res;
            }else{
                // need to pop, still finding the same jth element
                res.add("Pop");
            }
            i++;
        }
        return new ArrayList(); // can't build the stack
    }
}
