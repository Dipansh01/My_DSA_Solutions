class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int res = 0;
        int i = 1;
        while(i <= n-2){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                int j = i;
                int count = 1;
                while(j > 0 && arr[j] > arr[j-1]){
                    j--;
                    count++;
                }
                while(i < n-1 && arr[i] > arr[i+1]){
                    i++;
                    count++;
                }
                res = Math.max(res, count);
            }
            else{
                i++;
            }
        }
        return res;
    }
}