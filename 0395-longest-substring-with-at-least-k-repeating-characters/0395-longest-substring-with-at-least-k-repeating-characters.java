class Solution {
    public int longestSubstring(String s, int k) {
            return ans(s , 0 ,s.length(),k);
    }
    public int ans (String s , int start , int end , int k ){
        if(end-start <k){
            return 0;
        }
          int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for(int i = start ; i<end ; i++){
            if(freq[s.charAt(i)-'a'] < k ){
                int left = ans(s , start , i , k);
                int right = ans ( s , i+1 , end , k);
                return Math.max(left , right);
            }
        }
        return end - start;
    }
}