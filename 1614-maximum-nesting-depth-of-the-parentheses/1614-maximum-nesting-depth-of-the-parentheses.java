class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int res = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push('(');
            }
            else if(ch == ')'){
                res = Math.max(res, st.size());
                st.pop();
            }
        }
        return res;
    }
}