class Solution {
    public String countAndSay(int n) {
        return calculateRLE(n);
    }

    String calculateRLE(int n){
        // base condition:
        if(n == 1){
            return "1";
        }

        // recurse here
        String prevRLE = calculateRLE(n-1);
        // process this - transform the result from last step
        StringBuilder processedStr = new StringBuilder();
        int i=0;
        while( i < prevRLE.length() ){
            char c = prevRLE.charAt(i);
            int count = 1;
            while(i < prevRLE.length()-1 && prevRLE.charAt(i) == prevRLE.charAt(i+1)){
                i++;
                count++;
            }
            // append count and char
            processedStr.append(count+ "");
            processedStr.append(c + "");
            i++;
        }
        // feed it back sinply by returning from here
        return processedStr.toString();
    }
}
