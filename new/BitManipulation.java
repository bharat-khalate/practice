package new;

public class BitManipulation {
    
}


/**
 * class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=0;
        int high=piles.length-1;

        while(low<high){
            int mid=low+(high-low)/2;

            if(check(mid)){
                high=mid;
            }else{
                low=mid-1;
            }
        }
        return mid;
    }
}


Bit Manipulation
find if even -> n&1==0 -> even
remove last set bit -> n&n-1
keep only last set bit -> n&(-n)
a^0=a  a^a=a  a^b^a=b
swap 2 numbers-> a=a^b
		 b=a^b
		 a=a^b
sub sequence ->
		for(int mask=0;mask< (1<<n);++mask){
		  for(int i=0;i<n;i++){
			if(mask & (1<<i) !=0){
				nums[i]=
			}	
		}
count no of 1's in binary string->
		int i=9;
		while(i>0){
			i=i&(i-1);
			count++;
		}
count no of 1's for multiple input
	int arr[]=new int[input.length]
	for(int i=0;i<inpt;i++){
	 arr[i]=arr[i>>1]+ (i&1)
	}

 */