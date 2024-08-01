class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(String str: details){
            String age = str.substring(11,13);
            count += age.compareTo("60") > 0 ? 1: 0;
        }
        return count;
    }
}
