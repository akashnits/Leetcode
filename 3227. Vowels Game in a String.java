class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> vowelSet = new HashSet();
        // Alice - odd number of vowels
        // bob - even number of vowels
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');

        // if s has odd number of vowels - Alice pick all and wins
        // if s has even number of vowels - Alice pick odd number, leaves odd for Bob who picks even
        // leaves odd for Alice, Alice picks and wins

        // Alice always wins if there's a vowel
        for(char c: s.toCharArray()){
            if(vowelSet.contains(c)){
                return true;
            }
        }
        return false;
    }

}
