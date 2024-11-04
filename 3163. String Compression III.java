class Solution {
    public String compressedString(String word) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        char prevChar = '\0'; // Use null character as the initial value

        for (char currChar : word.toCharArray()) {
            if (currChar == prevChar) {
                count++;
            } else {
                // Append the previous character's count if it's not the initial character
                if (prevChar != '\0') {
                    res.append(count).append(prevChar);
                }
                // Reset count for the new character
                count = 1;
                prevChar = currChar;
            }
        }

        // Append the last character and its count
        if (prevChar != '\0') {
            res.append(count).append(prevChar);
        }
        
        return res.toString();
    }
}
