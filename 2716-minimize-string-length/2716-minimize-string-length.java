class Solution {
    public int minimizedStringLength(String s) {
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        int ans = 0;
        for(int i=0;i<26;i++){
            if(freq[i] != 0){
                ans++;
            }
        }
        return ans;
    }
}