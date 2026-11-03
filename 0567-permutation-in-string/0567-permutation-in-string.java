class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        int i = 0;
        int j = 0;
        while(j < m){
            map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0)+1);
            if(j-i+1 > n){
                char ch = s2.charAt(i);
                map2.put(ch, map2.get(ch) - 1);
                if(map2.get(ch) == 0){
                    map2.remove(ch);
                }
                i++;
            }
            if(map1.equals(map2)){
                return true;
            }
            j++;
        }
        return false;
    }
}