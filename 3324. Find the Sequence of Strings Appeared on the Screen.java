class Solution {
    public List<String> stringSequence(String target) {
        int n = target.length();
        
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList();
        for (int i = 0; i < n; i++) {
            char c = target.charAt(i);
            char choice = 'a';

            while (choice != c) {
                sb.append(choice);  // Add the current character
                res.add(sb.toString());
                sb.deleteCharAt(i);

                // Increment and wrap around using modulo arithmetic
                choice++;
                choice = (char) ('a' + (choice - 'a') % 26);
            }

            // Add the target character itself
            sb.append(c);
            res.add(sb.toString());
        }
        return res;
    }
}
