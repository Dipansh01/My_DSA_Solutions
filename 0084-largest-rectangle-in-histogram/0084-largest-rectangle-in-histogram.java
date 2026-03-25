class Solution {
    public int largestRectangleArea(int[] heights){
        int maxArea = Integer.MIN_VALUE;
        int n = heights.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        // for pse :
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }
            else{
                pse[i] = st.peek();
            }
            st.push(i);
        }

        // restore the stack :
        st.clear();

        // for nse :
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = n;
            }
            else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        for(int i=0;i<n;i++){
            int currArea = heights[i] * (nse[i]-pse[i]-1);
            maxArea = Math.max(maxArea,currArea);
        }
        return maxArea;
    }
}