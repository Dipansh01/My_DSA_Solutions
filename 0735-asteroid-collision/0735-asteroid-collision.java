class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int curr : asteroids){
            boolean destroyed = false;
            while(!st.isEmpty() && curr < 0 && st.peek() > 0){
                if(st.peek() < -curr){
                    st.pop();
                }
                else if(st.peek() == -curr){
                    st.pop();
                    destroyed = true;
                    break;
                }
                else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                st.push(curr);
            }
        }
        int[] res = new int[st.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i] = st.pop();
        }
        return res; 
    }
}