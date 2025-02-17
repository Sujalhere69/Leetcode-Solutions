class Solution {
    private int sequenceCount(int[] charCount) {
        int totalCount=0;
        for(int i=0;i<26;i++)   {
            if(charCount[i]==0) continue;
            totalCount++;
            charCount[i]--;
            totalCount+=sequenceCount(charCount);
            charCount[i]++;
        }
        return totalCount;
    }
    public int numTilePossibilities(String tiles) {
        int[] charCount=new int[26];
        for(char ch: tiles.toCharArray())   charCount[ch-'A']++;
        return sequenceCount(charCount);
    }
}