class Solution {
    // recursive approach 
    public List<Integer> getRow(int rowIndex) {
        // base condition
        if(rowIndex == 0){
            List<Integer> list = new ArrayList();
            list.add(0,1);
            return list;
        }
        
        //break into smaller sub-problems and solve to reach the solution
        return compute(rowIndex, getRow(rowIndex-1));
    }
    
    private List<Integer> compute(int row, List<Integer> list){
        List<Integer> result = new ArrayList();
        
        for(int i=0; i < row+1; i++){
            result.add(( i < row ? list.get(i) : 0) + (i > 0 ? list.get(i-1) : 0));
        }
        return result;
    }
    
    // dp approach
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
	    if (rowIndex < 0)
		    return list;

	    for (int i = 0; i < rowIndex + 1; i++) {
		    list.add(0, 1);
		    for (int j = 1; j < list.size() - 1; j++) {
			    list.set(j, list.get(j) + list.get(j + 1));
		    }
	    }
	    return list;
    }
}
