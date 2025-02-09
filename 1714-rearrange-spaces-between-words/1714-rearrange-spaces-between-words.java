class Solution {
    public String reorderSpaces(String text) {
        int spaces = (int) text.chars().filter(ch -> ch == ' ').count();
        String words[] = text.trim().split("\\s+");

        int spaceBetween = words.length > 1 ? spaces / (words.length - 1) : 0;
        int extraSpaces = words.length > 1 ? spaces % (words.length - 1) : spaces;

        StringBuilder st = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            st.append(words[i]);
            if (i < words.length - 1) {
                for (int j = 0; j < spaceBetween; j++) {
                    st.append(" ");
                }
            }
        }

        while (extraSpaces-- > 0) {
            st.append(" ");
        }

        return st.toString();
    }
}
