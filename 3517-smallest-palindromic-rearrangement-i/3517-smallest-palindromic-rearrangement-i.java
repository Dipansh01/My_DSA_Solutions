class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];
        StringBuilder sb = new StringBuilder();
        boolean odd = false;
        char oddChar = s.charAt(0);
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i] != 0){
                if(freq[i]%2 != 0){
                    odd = true;
                    oddChar = (char)('a' + i);
                }
                int temp = freq[i]/2;
                while(temp != 0){
                    sb.append((char)('a'+i));
                    temp--;
                }
            }
        }
        StringBuilder rev = new StringBuilder(sb);
        rev.reverse();
        if(odd){
            sb.append(oddChar);
        }
        sb.append(rev);
        return sb.toString();
    }
}