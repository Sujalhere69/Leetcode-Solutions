import java.util.*;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        char[] chars = {'a', 'b', 'c'};
        backTrack(n, new StringBuilder(), list, chars);
        
        return k <= list.size() ? list.get(k - 1) : "";
    }

    private void backTrack(int n, StringBuilder st, List<String> list, char[] chars) {
        if (st.length() == n) {
            list.add(st.toString());
            return;
        }

        for (char c : chars) {
            if (st.length() == 0 || st.charAt(st.length() - 1) != c) { // Ensure no two adjacent chars are the same
                st.append(c);
                backTrack(n, st, list, chars);
                st.deleteCharAt(st.length() - 1);
            }
        }
    }
}
