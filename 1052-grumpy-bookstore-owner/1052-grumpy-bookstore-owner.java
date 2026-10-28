class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int n = customers.length;
        for(int i=0;i<n;i++){
            if(grumpy[i] == 0){
                satisfied += customers[i];
            }
        }
        int unSatisfied = 0;
        for(int i=0;i<minutes;i++){
            if(grumpy[i] == 1){
                unSatisfied += customers[i];
            }
        }
        int maxUnSatisfied = unSatisfied;
        for(int i=minutes;i<n;i++){
            if(grumpy[i] == 1){
                unSatisfied += customers[i];
            }
            if(grumpy[i-minutes] == 1){
                unSatisfied -= customers[i-minutes];
            }
            maxUnSatisfied = Math.max(maxUnSatisfied, unSatisfied);
        }
        return satisfied + maxUnSatisfied;
    }
}