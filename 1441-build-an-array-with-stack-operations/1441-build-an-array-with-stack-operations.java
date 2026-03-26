class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> stack = new ArrayList<>();
        int j=0;
        for(int i=1;i<=n && j<target.length;i++){
            if(target[j] == i){
                stack.add("Push");
                j++;
            }
            else{
                stack.add("Push");
                stack.add("Pop");
            }
        }
        return stack;
    }
}