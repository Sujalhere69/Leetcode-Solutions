class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum =0;
        int minSum =0;
        int currentMax=0;
        int currentMin =0;
        for(int i =0 ; i<nums.length ; i++){
            currentMax+=nums[i];
            currentMin+=nums[i];
            maxSum = Math.max(currentMax , maxSum);
            minSum = Math.min(currentMin ,minSum);
            if(currentMax <0){
                currentMax =0;
            }
            if(currentMin >0){
                currentMin =0;
            }
        }
        return Math.max(maxSum, Math.abs(minSum));  
    }
}