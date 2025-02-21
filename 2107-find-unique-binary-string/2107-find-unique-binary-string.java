import java.util.*;

class Solution {
    public String findDifferentBinaryString(String[] num) {
        int n = num.length;
        Set<String> set = new HashSet<>(Arrays.asList(num));
        List<String> list = new ArrayList<>();

        backTrack(0, new StringBuilder(), n, list);

        for (String x : list) {
            if (!set.contains(x)) {
                return x;
            }
        }
        return "";
    }

    public void backTrack(int index, StringBuilder st, int n, List<String> list) {
        if (index == n) {
            list.add(st.toString());
            return;
        }
        
        // Append '0'
        st.append('0');
        backTrack(index + 1, st, n, list);
        st.deleteCharAt(st.length() - 1);

        // Append '1'
        st.append('1');
        backTrack(index + 1, st, n, list);
        st.deleteCharAt(st.length() - 1);
    }
}
