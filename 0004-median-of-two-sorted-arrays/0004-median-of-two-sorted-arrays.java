class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int x = 0;
        int[] a = new int[nums1.length + nums2.length];
        int o = a.length;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                a[x] = nums1[i];
                i++;
            } else {
                a[x] = nums2[j];
                j++;
            }
            x++;
        }

        while (i < nums1.length) {
            a[x] = nums1[i];
            i++;
            x++;
        }

        while (j < nums2.length) {
            a[x] = nums2[j];
            j++;
            x++;
        }

        if (o % 2 == 0) {
            int mid1 = a[o / 2 - 1];
            int mid2 = a[o / 2];
            return (double) (mid1 + mid2) / 2;
        } else {
            return a[o / 2];
        }
    }
}




// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {


// double d=0;
// int m = nums1.length;
// int n = nums2.length;
// int o = m+n;
// int a[]= new int[o];
// System.arraycopy(nums1,0,a,0,m);
// System.arraycopy(nums2,0,a,m,n);
// int left = 0;
// int right=a.length-1;
// Arrays.sort(a);
// if(o%2==0){
//     int mid1=a[o/2-1];
//     int mid2=a[o/2];
//     return (double) (mid1+mid2)/2;
// }else{
//     return  a[o/2];
// }

//     }
// }