class Solution {
    public int minOperations(int[] nums, int k) {
      PriorityQueue<Long> pq = new PriorityQueue<>();
     for (int num : nums) {
            pq.add((long) num);
        }
        long count = 0;
        while(pq.peek() < k){
        

            count++;
            long x = pq.poll();
            long y = pq.poll();
            long ans = Math.min(x,y) * 2 + Math.max(x,y);
            pq.add(ans);
        }
        return (int) count;
    }
}