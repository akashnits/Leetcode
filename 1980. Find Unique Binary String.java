class Solution {
    String res;
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet();
        for(String num: nums){
            set.add(num);
        }
        permute(nums.length, set, "");
        return res;
    }

    // using i/p o/p method, can also be solve using backtracking
    boolean permute(int n, Set<String> set, String op){
        // base condition
        if(op.length() == n){
            // check if it's in set
            if(!set.contains(op)){
                res = op;
                return true; // not in set, so result is found
            }else{
                // in the set, so false
                return false;
            }
        }

        // choices we have - we can either append -> '0' or '1'
        String output1 = op + '0';
        String output2 = op + '1';

        if(permute(n, set, output1)) {
            return true;
        }

        if(permute(n, set, output2)) {
            return true;
        }

        return false;
    }
}
