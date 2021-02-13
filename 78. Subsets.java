class Solution {
    //Idea is to use IP-OP method, intialize input with given input and output with empty
    //either pick the element or dont
    //reduct list by 1 at each step

    List<List<Integer>> result= new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {

        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        helper(numsList, new ArrayList());
        return result;
    }

    //helper function
    private void helper(List<Integer> numsInput, List<Integer> output ){
        if(numsInput.size() == 0){
            //add output to result
            result.add(output);
            return;
        }

        //using output/input method - select or ignore
        //ignore
        List<Integer> op1= new ArrayList();
        op1.addAll(output);
        //select
        output.add(numsInput.get(0));
        List<Integer> op2 = new ArrayList();
        op2.addAll(output);



        //remove the element from input to make it smaller
        numsInput = numsInput.subList(1, numsInput.size());

        //recurse
        helper(numsInput, op1);
        helper(numsInput, op2);
    }
}
