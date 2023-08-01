class Solution {
    List<List<Integer>> result= new ArrayList();

    public List<List<Integer>> combine(int n, int k) {
        solve(n, k, 1, new ArrayList());
        return result;
    }
    
    void solve(int n, int k,  int start, List<Integer> output){
        //base condition
        if(output.size() == k){
            result.add(new ArrayList(output));
            return;
        }
        
        for(int i=start; i <= n; i++){
            output.add(i);
            
            solve(n, k, i+1, output);
            
            output.remove(output.size()-1);
        }
    }
}
