class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        int greatest = arr[n-1];
        res[n-1] = -1;
        for(int i=n-2;i>=0;i--){
            res[i] = greatest;
            greatest = Math.max(greatest, arr[i]);
        }
        return res;
    }
}