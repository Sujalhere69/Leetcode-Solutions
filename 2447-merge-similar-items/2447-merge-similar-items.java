class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> list = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int [] arr : items1){
             map.put(arr[0], map.getOrDefault(arr[0], 0) + arr[1]);
        }
        for(int [] arr : items2){
              map.put(arr[0], map.getOrDefault(arr[0], 0) + arr[1]);
        }
        for(Map.Entry<Integer,Integer>entry : map.entrySet() ){
            int key = entry.getKey();
            int value = entry.getValue();
         list.add(Arrays.asList(key, value));

        }
        return list;
    }
}