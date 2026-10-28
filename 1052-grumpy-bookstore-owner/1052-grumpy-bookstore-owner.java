class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int n = customers.length;
        int unSatisfied = 0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i] == 1){
                unSatisfied += customers[i];
            }
            else{
                satisfied += customers[i];
            }
        }
        int maxUnSatisfied = unSatisfied;
        for(int i=minutes;i<n;i++){
            if(grumpy[i] == 1){
                unSatisfied += customers[i];
            }
            else{
                satisfied += customers[i];
            }
            if(grumpy[i-minutes] == 1){
                unSatisfied -= customers[i-minutes];
            }
            maxUnSatisfied = Math.max(maxUnSatisfied, unSatisfied);
        }
        return satisfied + maxUnSatisfied;
    }
}