class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0; // pointer for name
        int j = 0; // pointer for typed
        
        int nameLen = name.length();
        int typedLen = typed.length();
        
        while (j < typedLen) {
            if (i < nameLen && name.charAt(i) == typed.charAt(j)) {
                // Characters match, move both pointers
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // Current character in typed is a long press of the previous character
                j++;
            } else {
                // Mismatch found
                return false;
            }
        }
        
        // Check if we have consumed all characters in name
        return i == nameLen;
    }
}
