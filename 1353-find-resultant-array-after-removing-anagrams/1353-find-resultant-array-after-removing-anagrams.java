class Solution {
    public List<String> removeAnagrams(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        String prevSorted = "";
        for (int i = 0; i < words.length; i++) {
            char[] arr = words[i].toCharArray();
            Arrays.sort(arr);
            String sortedWord = new String(arr);

            if (!sortedWord.equals(prevSorted)) { 
                result.add(words[i]);
                prevSorted = sortedWord;
            }
        }
        return result;
    }
}