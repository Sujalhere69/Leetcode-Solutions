class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String i : wordList){
            set.add(i);
        }
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(beginWord,1));
    set.remove(beginWord);
    while(!q.isEmpty()){
        String word =q.peek().first;
        int steps = q.peek().second;
         q.poll();
         if(word.equals(endWord)){
            return steps;
         }
char wordArray[]= word.toCharArray();
for(int i =0 ; i<wordArray.length;i++){
    char original = wordArray[i];
    for(char ch ='a';ch<='z';ch++){
      
      if(ch == original){
        continue;
      }
      wordArray[i]=ch;
          String replacedWord =new String(wordArray);
          if(set.contains(replacedWord)){
            set.remove(replacedWord);
            q.add(new Pair(replacedWord,steps+1));







          }
          wordArray[i]=original;
    }
  
}
    }
    return 0;

    }
    class Pair{
        String first;
        int second ;
          Pair(String first , int second){
            this.first=first;
            this.second=second;
        }
    }
}