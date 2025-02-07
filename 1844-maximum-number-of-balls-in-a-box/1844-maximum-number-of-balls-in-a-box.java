class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max =Integer.MIN_VALUE;
        for(int i =lowLimit ; i<=highLimit;i++){
    int ans = get(i);
    map.put(ans , map.getOrDefault(ans,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            max=Math.max(max,entry.getValue());
        }
        return max;
    }
    public int get(int num){
        int sum =0;
        while(num != 0){
            int r = num  %10;
sum += r;
num=num/10;
        }
        return sum;
    }
}