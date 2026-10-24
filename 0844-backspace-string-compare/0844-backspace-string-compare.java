class Solution {
    public boolean backspaceCompare(String s, String t) {
        return updated(s).equals(updated(t));
    }
    public String updated(String str){
        StringBuilder sb = new StringBuilder();
        int backspace = 0;
        for(int i = str.length()-1; i >= 0; i--){
            char ch = str.charAt(i);
            if(ch == '#'){
                backspace++;
            }
            else{
                if(backspace != 0){
                    backspace--;
                    continue;
                }
                else{
                    sb.insert(0, ch);
                }
            }
        }
        return sb.toString();
    }
}