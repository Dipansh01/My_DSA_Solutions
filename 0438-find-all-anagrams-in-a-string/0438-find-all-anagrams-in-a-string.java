class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        int[] freq = new int[26];
        List<Integer> res = new ArrayList<>();
        for(char ch : p.toCharArray()){
            freq[ch - 'a']++;
        }
        int i = 0;
        int j = 0;
        int matches = 0;
        while(j < m){
            int idx = s.charAt(j) - 'a';
            if(freq[idx] > 0){
                matches++;
            }
            freq[idx]--;
            if(j-i+1 > n){
                int removeIdx = s.charAt(i) - 'a';
                freq[removeIdx]++;
                if(freq[removeIdx] > 0){
                    matches--;
                }
                i++;
            }
            if(j-i+1 == n && matches == n){
                res.add(i);
            }
            j++;
        }
        return res;
    }
}