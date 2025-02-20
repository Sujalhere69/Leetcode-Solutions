class Solution {
    public List<String> stringMatching(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(String i : words){
            map.put( i , i.length());
        }
        List<String> list = new ArrayList<>();
        for(int i =0 ; i<words.length ; i++){
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(entry.getValue() > words[i].length()){
                    if(entry.getKey().contains(words[i])){
                        list.add(words[i]);
                        break;
                    }
                }
            }
        }
        return list;
    }
}