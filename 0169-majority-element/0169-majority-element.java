class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = -1;
        for(int num : nums){
            if(count == 0){
                count = 1;
                ele = num;
            }
            else if(num == ele){
                count++;
            }
            else{
                count--;
            }
        }
        return ele;
    }
}