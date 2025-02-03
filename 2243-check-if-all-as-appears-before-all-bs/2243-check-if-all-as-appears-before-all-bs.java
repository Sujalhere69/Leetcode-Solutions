class Solution {
    public boolean checkString(String s) {
        int ans []= new int[2];
for(int i =0 ; i<s.length();i++){
    if(s.charAt(i)=='a' && ans['b'-'a'] >0){
        return false;
    }
    ans[s.charAt(i)-'a']++;

}
return true;
    }
}