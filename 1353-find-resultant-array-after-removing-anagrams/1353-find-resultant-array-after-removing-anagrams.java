class Solution {
    public List<String> removeAnagrams(String[] words) {
        for(int i =words.length-1; i>0;i--){
            if(words[i].length()!= words[i-1].length()){
                continue;
            }
            char [] curr = words[i].toCharArray();
            char [] prev = words[i-1].toCharArray();
            Arrays.sort(curr);
            Arrays.sort(prev);
            boolean flag = true;
            for(int j =0 ; j<curr.length ; j++){
                if(curr[j] != prev[j]){
                    flag = false;
                }
            }
            if(flag == true){
                words[i]= " ";
            }
        }
        List<String> list = new ArrayList<>();
        for(int i =0 ; i<words.length;i++){
            if(words[i]!= " "){
                list.add(words[i]);
            }
        }
        return list;
    }
}