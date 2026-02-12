import java.util.ArrayList;
import java.util.List;

public class MaxSumAfterRotation {
     public static void main(String args[]) {
        var numList = new ArrayList<>(List.of(8, 3, 1, 2));
        int curSum=0, totalSum=0;
        for(int i=0; i<numList.size();i++){
            totalSum+=numList.get(i);
            curSum+=numList.get(i)* i;
        }
        int res=curSum;
        for(int i= 1; i<numList.size();i++){
            int nextValue=curSum-(totalSum-numList.get(i-1))+numList.get(i-1)*(numList.size()-1);
            curSum=nextValue;
            res=Math.max(res, nextValue);
        }
        System.out.println(res);
    }
}
