class Solution {
    public int minEatingSpeed( int [] piles , int  h ) {
        int max1 = 0;
        for(int i = 0 ; i < piles.length ; i ++)
            max1 = Math.max( max1 , piles[i] ) ;
        return binarySearch(1 , max1 , piles , h , max1 ) ;
    }
    private int binarySearch( int start , int end , int p[] , int  hours ,int  ans ){
        int h = hours;
        if( start > end )   return ans;
        int mid = start + ( end - start ) / 2 ;
        for(int i = 0 ; i < p.length ; i++ )
        {
            int curr = p[i] ;
            if(h == 0) 
            {
                return binarySearch( mid + 1 , end , p , hours , ans ) ;
            }
            h -= ( curr + mid - 1 ) / mid ;
        }
        if( h >= 0 ) 
        {
            ans = Math.min( ans , mid ) ;
            return binarySearch( start , mid - 1 , p , hours , ans ) ;
        
        }
        else    return binarySearch( mid + 1 , end , p , hours , ans ) ;
    }
}