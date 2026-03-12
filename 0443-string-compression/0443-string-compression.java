class Solution {
    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        String str = "";
        int j,i=0;
        for(j=0;j<chars.length;j++){
            if(chars[i] != chars[j]){
                int freq = j-i;
                str += chars[i];
                if(freq != 1){
                    str += freq;
                }
                i = j;
            }
        }
        int freq = j-i;
        str += chars[i];
        if(freq != 1){
            str += freq;
        }
        for(i=0;i<str.length();i++){
            chars[i] = str.charAt(i);
        }
        return str.length();
    }
}