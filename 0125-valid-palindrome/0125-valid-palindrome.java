class Solution {
    public boolean isAlphaNumericCharacter(Character c){
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(!isAlphaNumericCharacter(ch1)){
                i++;
                continue;
            }
            if(!isAlphaNumericCharacter(ch2)){
                j--;
                continue;
            }
            if(Character.toLowerCase(ch1) != Character.toLowerCase(ch2)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}