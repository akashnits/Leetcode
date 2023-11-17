class Solution {
    public String sortVowels(String s) {
        // vowels count is 10 including lowercase and uppercase; track frequencies
        int[] count = new int[100];

        for(char c: s.toCharArray()){
            if(isVowel(c)){
                count[c-'A']++;
            }
        }

        // loop over string s and replace vowels
        StringBuilder res = new StringBuilder();
        String sortedVowel = "AEIOUaeiou";
        int j=0;
        for(char ch: s.toCharArray()){
            if(isVowel(ch)){
                // replace with a vowel with lower ascii
                // Skip to the character which is having remaining count.
                while (count[sortedVowel.charAt(j) - 'A'] == 0) {
                    j++;
                }

                // use this char
                res.append(sortedVowel.charAt(j));
                count[sortedVowel.charAt(j) - 'A']--;
            }else{
                // leave consonant as it
                res.append(ch);
            }
        }
        return res.toString();
    }

    boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'o'|| c == 'u'|| c == 'i' 
            || c == 'A' || c == 'E' || c == 'O'|| c == 'U'|| c == 'I';
    }
}
