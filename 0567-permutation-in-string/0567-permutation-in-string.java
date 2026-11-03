class Solution {
    public String sort(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String sortedString = new String(arr);
        return sortedString;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        s1 = sort(s1);
        for(int i=0;i<=m-n;i++){
            String subString = s2.substring(i,i+n);
            subString = sort(subString);
            if(s1.equals(subString)){
                return true;
            }
        }
        return false;
    }
}