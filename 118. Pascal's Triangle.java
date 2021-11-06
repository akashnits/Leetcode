class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> initialList= new ArrayList();
        initialList.add(1);
        result.add(initialList);
        
        for(int i=1; i < numRows; i++ ){
            
            for(int j=0; j<=i; j++){
                // get list at i i.e. for that row
                List<Integer> list= null;
                if(i == result.size()){
                    list = new ArrayList();
                    result.add(list);
                }else{
                    list= result.get(i);
                }
                
                List<Integer> prevList = result.get(i-1);
                
                int sum = (j == 0 ? 0 : prevList.get(j-1)) + 
                    (j == i ? 0 : prevList.get(j));
                list.add(sum);
            }
        }
        
        return result;
    }
}
