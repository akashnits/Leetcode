class Solution {
    public String boldWords(String[] words, String s) {
        int len = s.length();
        boolean[] marker = new boolean[len];

        // part 1: mark bold positions
        for (String word : words) {
            int idx = s.indexOf(word);

            while (idx != -1) {
                for (int i = idx; i < idx + word.length(); i++) {
                    marker[i] = true;
                }
                idx = s.indexOf(word, idx + 1);
            }
        }

        // part 2: build result
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < len; i++) {

            // start tag
            if (marker[i] && (i == 0 || !marker[i - 1])) {
                res.append("<b>");
            }

            res.append(s.charAt(i));

            // end tag
            if (marker[i] && (i == len - 1 || !marker[i + 1])) {
                res.append("</b>");
            }
        }

        return res.toString();
    }
}
