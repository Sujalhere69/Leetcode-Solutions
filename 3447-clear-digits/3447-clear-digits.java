class Solution {
    public String clearDigits(String s) {
        StringBuilder stack = new StringBuilder(); // Using StringBuilder as a stack

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (stack.length() > 0) {
                    stack.deleteCharAt(stack.length() - 1); // Remove last non-digit character
                }
            } else {
                stack.append(ch); // Add non-digit characters to stack
            }
        }

        return stack.toString();
    }
}
