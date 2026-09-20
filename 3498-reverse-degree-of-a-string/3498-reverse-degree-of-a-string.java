class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        for(int i=1;i<=s.length();i++){
            char ch = s.charAt(i-1);
            int revAlpha = 26 - ((int)ch - 97);
            res += revAlpha * i;
        }
        return res;
    }
}