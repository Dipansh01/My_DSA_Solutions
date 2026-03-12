class Solution {
    public String compressedString(String word) {
        char arr[] = word.toCharArray();
        StringBuilder ans = new StringBuilder();
        int i=0,j;
        for(j=0;j<arr.length;j++){
            if(arr[i] != arr[j]){
                int freq = j-i;
                while(freq > 9){
                    ans.append("9").append(arr[i]);
                    freq = freq-9;
                }
                if(freq != 0){
                    ans.append(freq);
                    ans.append(arr[i]);
                }
                i = j;
            }
        }
        int freq = j-i;
        while(freq > 9){
            ans.append("9").append(arr[i]);
            freq = freq-9;
        }
        if(freq != 0){
            ans.append(freq);
            ans.append(arr[i]);
        }
        return ans.toString();
    }
}