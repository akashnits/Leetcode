class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");

        String res = words[words.length-1];
        return res.length();
    }
}
