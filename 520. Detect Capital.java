class Solution {
    // Approach: keep track of small letters
    // fail conditions:
    // 1. no capital after small
    // 2. no small after multiple capital
    public boolean detectCapitalUse(String word) {
        // create set of small letter and capital letters

        Set<Character> lowerCaseSet = new HashSet();

        for(int i=0; i < 26; i++){
            lowerCaseSet.add((char) ('a' +i));
        }

        boolean foundLowerCaseBefore = false;
        boolean foundMultipleUpperCaseBefore = false;
        int count = 0;

        char[] wordChars = word.toCharArray();
        for(char c: wordChars){
            // figure out if it's uppercase/lowercase
            boolean isUpperCase = !lowerCaseSet.contains(c);
            if(!isUpperCase){
                if(foundMultipleUpperCaseBefore){
                    return false;
                }
                foundLowerCaseBefore= true;
            }else{
                count++;
                // this is upperCase
                if(foundLowerCaseBefore){
                    return false;
                }else if(count == 2){
                    foundMultipleUpperCaseBefore= true;
                }
            }
        }
        return true;
    }
}
