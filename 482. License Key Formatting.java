class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int n =0;
        List<Character> letters = new ArrayList();
        
        for(char c: s.toCharArray()){
            if(c == '-'){
                continue;
            }else{
                // letter
                letters.add(Character.toUpperCase(c));
            }
        }
        
        n = letters.size();
        
        StringBuilder res = new StringBuilder();
        
        int idx = n-1;
        while(idx >= 0){
            int groupSize = k;
            while(groupSize > 0 && idx >= 0){
                res.insert(0, letters.get(idx));
                idx--;
                groupSize--;
            }
            if(idx >= 0){
                // append dash
                res.insert(0, "-");
            }
        }
        
        return res.toString();
    }
}
