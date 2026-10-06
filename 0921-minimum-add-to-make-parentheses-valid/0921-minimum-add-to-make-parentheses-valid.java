class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int res = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                openCount++;
            }
            else{
                if(openCount > 0){
                    openCount--;
                }
                else{
                    res++;
                }
            }
        }
        return openCount + res;
    }
}