class Solution {
    public String smallestNumber(String pattern) {
        boolean [] used = new boolean[10];
        StringBuilder result = new StringBuilder();
        int [] num = new int[pattern.length()+1];
        backTrack( pattern , 0,used , result , num  );
        return result.toString();
    }
    public boolean backTrack(String pattern , int index ,boolean [] used , StringBuilder st,int [] num){
        if(index > pattern.length()){
            for(int i =0 ; i<num.length;i++){
                st.append(num[i]);
            }
            return true;
        }
        for(int digit =1 ; digit<=9 ; digit++){
            if( !used[digit] && (index ==0|| isValid(num[index-1] , digit , pattern.charAt(index-1)))){
                used[digit]=true;
                num[index] = digit;
                if(backTrack(pattern , index+1 , used , st , num)){
                    return true;
                }else{
                    num [index]= 0;
                    used[digit]= false;
                }
            }
        }
        return false;
    }
    public boolean isValid(int prev , int curr ,  char ch){
        if((ch =='I' && curr> prev ) || ch=='D' && curr < prev){
            return true;
        }
        return false;
    }
}