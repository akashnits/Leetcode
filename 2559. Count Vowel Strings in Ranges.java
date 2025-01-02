class Solution {
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
    public int[] vowelStrings(String[] words, int[][] queries) {
        // presum
        int n = words.length;
        int[] preSumVowels = new int[n];

        for(int i =0; i < n; i++){
            String word = words[i];

            preSumVowels[i] = i > 0 ? preSumVowels[i-1] : 0;
            if(isWordWithVowels(word)){
                preSumVowels[i]++;
            }
        }

        int[] res = new int[queries.length];
        for(int k=0; k < queries.length; k++){
            int[] query = queries[k];

            int start = query[0];
            int end = query[1];

            if(start > 0){
                res[k] = preSumVowels[end] - preSumVowels[start-1];
            }else{
                res[k] = preSumVowels[end];
            }
        }

        return res;
    }

    boolean isWordWithVowels(String word){
        return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() -1));
    }
}
