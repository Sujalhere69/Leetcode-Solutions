class Solution {
    public String removeOccurrences(String s, String part) {
        char input []= s.toCharArray();
        char target []=part.toCharArray();
        char[] resultStack = new char[input.length];
        char targetEndChar = target[target.length-1];
        int stackSize =0 , targetLength =target.length;
        for(char currentChar : input){
            resultStack[stackSize++]=currentChar;
if(currentChar == targetEndChar && stackSize >=targetLength){
    int i = stackSize-1 , j = target.length-1;
    while(j >=0 && resultStack[i]==target[j]){
        i--;
        j--;
    }
    if(j<0){
        stackSize=i+1;
    }
}

            }
        
        return new String(resultStack,0,stackSize);
    }
}   