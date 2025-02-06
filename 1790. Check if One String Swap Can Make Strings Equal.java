class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        // find the indices where char differs
        // it shouldn't be more than 2

        int n = s1.length();
        List<Integer> indices = new ArrayList();

        int diff = 0;
        for(int i=0; i < n; i++){
            char c1= s1.charAt(i);
            char c2= s2.charAt(i);

            if(c1 != c2){
                diff++;
                indices.add(i);
            }

            if(diff > 2){
                return false;
            }
        }

        if(diff == 1){
            return false;
        }
        
        // swap and compare
        return (indices.size() == 0 || 
                ((s1.charAt(indices.get(0)) == s2.charAt(indices.get(1))) &&
                (s1.charAt(indices.get(1)) == s2.charAt(indices.get(0)))));
    }
}
