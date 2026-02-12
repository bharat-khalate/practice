import java.util.*;

public class ReverseInGroup {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
       int k=3;
       if(k>=numList.size()){
        Collections.reverse(numList);
       }
       for(int i=0;i<numList.size();i+=k){
        int start=i;
        int end=Math.min(i+k-1, numList.size()-1);
        while (start<end) {
            Collections.swap(numList, start, end);
            start++;
            end--;
        }
       }
       System.out.println(numList);
    }
}
