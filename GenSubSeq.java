import java.util.*;

public class GenSubSeq {
    public static void main(String[] args) {
        var numList=new ArrayList<>(List.of(1,2,3));
        for(int mask=1; mask<(1<<numList.size());mask++){
            var tempList=new ArrayList<Integer>();
            for(int i=0;i<numList.size();i++){
                if((mask & (1<<i))!=0)
                    tempList.add(numList.get(i));
            }
            System.out.println(tempList);
        } 
    }
}
