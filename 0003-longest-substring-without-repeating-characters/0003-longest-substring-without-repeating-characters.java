class Solution {
    public int lengthOfLongestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int i=0,j=0;
        int maxLen = 0;
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }
            else{
                maxLen = Math.max(maxLen,j-i);
                while(s.charAt(i) != s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
                j++;
            }
        }
        maxLen = Math.max(maxLen,j-i);
        return maxLen;
    }
}