class Solution {
    public String reversePrefix(String word, char ch) {
        int i = findFirstOccurence(word, ch);
        int n = word.length();

        if(i == -1){
            return word;
        }else{
            StringBuilder sb = new StringBuilder(word.substring(0, i+1));
            sb.reverse();

            if(i != word.length()-1){
                sb.append(word.substring(i+1, n));
            }
            return sb.toString();
        }
    }

    int findFirstOccurence(String word, char c){
        for(int i=0; i < word.length(); i++){
            if(c == word.charAt(i)){
                return i;
            }
        }
        return -1;
    }
}
