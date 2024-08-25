

class Solution {
    public int countPairs(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i=0; i < n-1; i++){
            for(int j=i+1; j < n; j++){
                int num1 = nums[i];
                int num2 = nums[j];

                // check if number contains same digits
                //  but positions of 2 digits is mixed
                if(checkIfValidPair(num1, num2)){
                    count++;
                }
            }
        }
        return count;
    }

    

    boolean checkIfValidPair(int num1, int num2){
        String s1 = String.valueOf(num1);
        String s2 = String.valueOf(num2);

        // make both string same length before comparing
        while (s1.length() < s2.length()) {
            s1 = "0" + s1;
        }
        while (s2.length() < s1.length()) {
            s2 = "0" + s2;
        }

        List<Integer> mismatches = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                mismatches.add(i);
                if(mismatches.size() > 2){
                    return false;
                }
            }
        }

        if (mismatches.size() == 0) {
            return true;
        }

        // If there are exactly two mismatches
        if (mismatches.size() == 2) {
            int i = mismatches.get(0);
            int j = mismatches.get(1);

            // Check if swapping the digits makes them equal
            return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
        }

        return false;
    }    
}
