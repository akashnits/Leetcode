class Solution {
    public boolean buddyStrings(String s, String goal) {

        Set<Character> charSet = new HashSet();
        if(s.length() != goal.length()){
            return false;
        }

        int countOOP = 0;
        List<Integer> indices = new ArrayList();
        boolean hasDuplicates= false;

        // we try finding out of place letters - 2 no.
        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(charSet.contains(ch)){
                hasDuplicates= true;
            }else{
                charSet.add(ch);
            }
            if(ch != goal.charAt(i)){
                if(++countOOP > 2){
                    // if out of place letter is > 2, return false
                    return false;
                }else{
                    // we save out of order index
                    indices.add(i);
                }
            }
        }

        // countOOP can be - 0, 1, 2
        if(countOOP == 2){
            // try swapping and comparing
            int index1= indices.get(0);
            int index2= indices.get(1);
           return (s.charAt(index1) == goal.charAt(index2) && s.charAt(index2) == goal.charAt(index1));
        }

        if(countOOP == 0){
            // we may swap if we have duplicates
            return hasDuplicates;
        }
        
        return false;
    }
}
