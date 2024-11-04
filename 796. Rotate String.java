class Solution {
    public boolean rotateString(String s, String goal) {
        return method2(s, goal);
    }

    // approach 1: simulation
    boolean method1(String s, String goal){
        if(s.length() != goal.length()){
            return false;
        }

        if(s.equals(goal)){
            return true;
        }

        // loop over and rotate by 1 each time
        int n = s.length();
        int idx = 1;
        while(idx < n){
            String rotatedString = s.substring(idx) + s.substring(0, idx);
            if(rotatedString.equals(goal)){
                return true;
            }
            idx++;
        }

        return false;
    }

    // approach 2: trick: create a String -> s+s , this should contain goal
    boolean method2(String s, String goal){
        // Check if the lengths are different
        if (s.length() != goal.length()) return false;

        String doubledString = s + s;

        // Use contains to search for 'goal' in 'doubledString'
        // If contains return true, 'goal' is a substring
        return doubledString.contains(goal);
    }
}
