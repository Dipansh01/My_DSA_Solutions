class Pair{
    String word;
    int level;
    Pair(String word, int level){
        this.word = word;
        this.level = level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair p = q.remove();
            String word = p.word;
            int steps = p.level;
            if(word.equals(endWord)){
                return steps;
            }
            for(int i=0;i<word.length();i++){
                char[] ch = word.toCharArray();
                for(int j=0;j<26;j++){
                    ch[i] = (char)('a' + j);
                    String newWord = new String(ch);
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, steps+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}