class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(char ch : p.toCharArray()){
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        int i = 0;
        int j = 0;
        while(j < m){
            map2.put(s.charAt(j), map2.getOrDefault(s.charAt(j), 0)+1);
            if(j-i+1 > n){
                char ch = s.charAt(i);
                map2.put(ch, map2.get(ch)-1);
                if(map2.get(ch) == 0){
                    map2.remove(ch);
                }
                i++;
            }
            if(map1.equals(map2)){
                res.add(i);
            }
            j++;
        }
        return res;
    }
}