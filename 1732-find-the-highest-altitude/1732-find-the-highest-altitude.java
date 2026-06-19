class Solution {
    public int largestAltitude(int[] gain) {
        int highAlt = 0;
        int currAlt = 0;
        for(int i=0;i<gain.length;i++){
            currAlt += gain[i];
            highAlt = Math.max(highAlt,currAlt);
        }
        return highAlt;
    }
}