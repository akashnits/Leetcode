class Solution {
    public char kthCharacter(int k) {
        String word = "a";
        while (word.length() < k) {
            word += shift(word);
        }
        return word.charAt(k-1);
    }

    private String shift(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c == 'z' ? 'a' : (char)(c + 1));
        }
        return sb.toString();
    }
}
