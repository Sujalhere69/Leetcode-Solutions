class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        
        // Reverse the string
        String rev = new StringBuilder(s).reverse().toString();
        
        // Create a new string with a separator
        String combined = s + "#" + rev;
        
        // Compute the LPS array
        int[] lps = computeLPS(combined);
        
        // Length of the longest palindromic prefix
        int longestPalindromeLength = lps[combined.length() - 1];

        // The suffix to be added (remaining part from the reversed string)
        String suffixToAdd = rev.substring(0, s.length() - longestPalindromeLength);
        
        // Form the shortest palindrome
        return suffixToAdd + s;
    }

    private int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int j = 0; // Length of the previous longest prefix suffix

        for (int i = 1; i < n; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = lps[j - 1]; // Move j to the previous LPS value
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        return lps;
    }
}
