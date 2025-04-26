class Solution {
    public int lengthOfLongestSubstring(String s) {
       int l =0 ; 
        int r =0 ;
         int n = s.length(); 
         int len =0 ; 
          int maxLen =0;
         int a[] = new int [255];
         for(int i =0 ; i<255 ; i++){
            a[i]=-1;
         }
         while(r < n){
            char curr =s.charAt(r);
            if(a[curr]!=-1 && a[curr]>= l){
                l= a[curr]+1;
                len = r-l+1;
            }
            a[curr]= r;
            len = r - l+1;
            maxLen = Math.max(maxLen,len);
            r++;
         }
         return maxLen;
    }
}