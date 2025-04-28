class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l =0 ; 
         int r = 0 ; 
          int x =0 ; 
          int [] ans = new int[nums1.length + nums2.length];
          int o = ans.length;
          while(l<nums1.length && r <nums2.length){
            if(nums1[l]<nums2[r]){
                ans[x++]=nums1[l++];
            }else{
                ans[x++]=nums2[r++];
            }
          }
          while(l<nums1.length){
            ans[x++]=nums1[l++];
          }
          while(r<nums2.length){
            ans[x++]=nums2[r++];
          }
if (o % 2 == 0) {
            int mid1 = ans[o / 2 - 1];
            int mid2 = ans[o / 2];
            return (double) (mid1 + mid2) / 2;
        } else {
            return ans[o / 2];
        }
    }
}