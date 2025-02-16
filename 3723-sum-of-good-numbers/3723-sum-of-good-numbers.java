class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean isGood = false;

            if (i - k >= 0 && i + k < n) {
                if (nums[i] > nums[i - k] && nums[i] > nums[i + k]) {
                    isGood = true;
                }
            } else if (i - k >= 0) {
                if (nums[i] > nums[i - k]) {
                    isGood = true;
                }
            } else if (i + k < n) {
                if (nums[i] > nums[i + k]) {
                    isGood = true;
                }
            } else {
                // If no valid neighbors exist, treat it as a good number
                isGood = true;
            }

            if (isGood) {
                sum += nums[i];
            }
        }
        return sum;
    }
}
