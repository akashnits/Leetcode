class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        return method2(allowed, words);
    }

    // using hashset
    int method1(String allowed, String[] words){
        Set<Character> set = new HashSet();
        for(char c: allowed.toCharArray()){
            set.add(c);
        }

        int count = 0;
        for(String word: words){
            boolean flag= true;
            for(char c: word.toCharArray()){
                if(!set.contains(c)){
                    flag = false;
                    break;
                }
            }
            count += flag ? 1 : 0;
        }

        return count;
    }

    // using bit manipulation
    int method2(String allowed, String[] words){
        int count = 0;
        // create a mask for allowed string
        int mask = 0;
        for(char c: allowed.toCharArray()){
            mask |= 1 << c;
        }

        // loop over words
        for(String word: words){
            boolean flag = true;
            for(char c: word.toCharArray()){
                // right shift the mask and & with 1, it must not be zero
                int bit = 1 & (mask >> c);
                if(bit == 0){
                    flag = false;
                    break;
                }
            }
            count += flag ? 1: 0;
        }
        return count;
    }
}
