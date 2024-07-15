class Solution {
    public String getSmallestString(String s) {
        int n = s.length();
        boolean swapped = false;
        StringBuilder res = new StringBuilder();

        int i = 0;
        while(i < n-1){
            int ele1 = Integer.parseInt(s.charAt(i) + "");
            int ele2 = Integer.parseInt(s.charAt(i+1) + "");

            // check for parity , not swapped and ele1 > ele2

            if(!swapped && (ele1 % 2 == ele2 % 2) && (ele1 > ele2)){
                // swap it
                res.append(ele2 + "");
                res.append(ele1 + "");
                swapped = true;
                i = i+2;
                break;
            }else{
                res.append(ele1); // we processed i
                i++;
            }
        }

        res.append(s.substring(i));

        return res.toString();
    }
}
