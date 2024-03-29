class Solution {
    //Idea: If we look closely, we can observe that
    //if K is before mid, the value remmains unchanged when compared to previous row
    //if k is greater than mid, it becomes compliment of previous row with index as K-mid 
    public int kthGrammar(int N, int K) {
        
        //base condition
        if(N == 1){
            return 0;
        }
        
        //Approach  - using recursive tree
        int mid = (int) Math.pow(2.0, N-1)/2;
        
        if(K <= mid){
            return kthGrammar(N-1, K);
        }else{
            return kthGrammar(N-1, K-mid) == 0 ? 1: 0;
        }
    }
}
