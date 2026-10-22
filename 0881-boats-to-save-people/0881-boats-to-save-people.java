class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] count = new int[limit+1];
        for(int wt : people){
            count[wt]++;
        }
        int index = 0;
        for(int val=1;val<=limit;val++){
            while(count[val] != 0){
                people[index] = val;
                count[val]--;
                index++;
            }
        }
        int i = 0;
        int j = people.length - 1;
        int boats = 0;
        while(i <= j){
            if(people[i] + people[j] <= limit){
                i++;
                j--;
            }
            else{
                j--;
            }
            boats++;
        }
        return boats;
    }
}