class Solution {
    public int numberOfBeams(String[] bank) {
        // for each r1 , find r2
        int res = 0;
        
        for(int r1=0; r1 < bank.length-1; r1++){
            // does r1 has security device
            if(!hasSecurityDevice(bank[r1])){
                continue;
            }

            // if r1 has security device, find corresponding r2
            int r2 = r1 + 1;
            while(!hasSecurityDevice(bank[r2])){
                r2++;
                if(r2 == bank.length){
                    // out of bounds, couldn't find r2
                    // return from here
                    return res;
                }
            } 

            // we have found valid r2, caculate lasers
            String s1= bank[r1];
            String s2 = bank[r2];

            res += calculateLasers(s1, s2);
        }
        return res;
    }

    public boolean hasSecurityDevice(String row){
        return row.contains("1");
    }

    public long calculateLasers(String s1, String s2){
        return (s1.chars().filter(ch -> ch == '1').count() * s2.chars().filter(ch -> ch == '1').count());
    }
}
