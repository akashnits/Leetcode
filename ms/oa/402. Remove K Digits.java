class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {
            // remove larger previous digits if possible
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(digit);
        }

        // if still have removals left, remove from the end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // remove leading zeros
        int i = 0;
        while (i < stack.length() && stack.charAt(i) == '0') {
            i++;
        }

        String result = (i == stack.length()) ? "0" : stack.substring(i);
        return result;
    }
}
