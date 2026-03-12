class Solution {
    public String compressedString(String word) {
        char arr[] = word.toCharArray();
        String ans = "";
        int i=0,j;
        for(j=0;j<arr.length;j++){
            if(arr[i] != arr[j]){
                int freq = j-i;
                while(freq > 9){
                    ans += "9" + arr[i];
                    freq = freq-9;
                }
                if(freq != 0){
                    ans += freq;
                    ans += arr[i];
                }
                i = j;
            }
        }
        int freq = j-i;
        while(freq > 9){
            ans += "9" + arr[i];
            freq = freq-9;
        }
        if(freq != 0){
            ans += freq;
            ans += arr[i];
        }
        i = j;
        return ans;
    }
}