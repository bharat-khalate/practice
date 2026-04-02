import java.util.HashMap;

/**
 * . Given: An unsorted array of integer numbers.
 * Goal: Determine the length of the longest consecutive elements sequence.
 * Example 1:
 * • Input = [100, 4, 200, 1, 3, 2]
 * • Output: 4
 * • Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4
 * 
 */

public class LongConsEle {

    public static int getLongestConsCount(int[] arr){
        int res =0;
        HashMap<Integer,Boolean> helperMap=new HashMap<>();
        for(int num:arr)helperMap.put(num, true);
        for(int i=0; i<arr.length;i++){
            if(!helperMap.containsKey(arr[i]-1)){
                int current=arr[i]+1;
                int count=1;
                while (helperMap.containsKey(current++)) {
                    count++;
                    i++;
                }
                res=Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String args[]){
        System.out.println(getLongestConsCount(new int[]{1, 3, 2,4}));
    }
}
