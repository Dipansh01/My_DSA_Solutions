class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for(char ch : t.toCharArray()){
            freq[ch]++;
        }
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int i = 0;
        int j = 0;
        while(j < s.length()){
            char ch = s.charAt(j);
            if(freq[ch] > 0){
                count++;
            }
            freq[ch]--;
            while(count == t.length()){
                if(j-i+1 < minLength){
                    minLength = j-i+1;
                    startIndex = i;
                }
                freq[s.charAt(i)]++;
                if(freq[s.charAt(i)] > 0){
                    count--;
                }
                i++;
            }
            j++;
        }
        if(startIndex == -1){
            return "";
        }
        return s.substring(startIndex, startIndex + minLength);
    }
}