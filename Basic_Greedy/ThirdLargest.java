
import java.util.*;

public class ThirdLargest {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 14, 2, 16, 10, 20      ).stream().sorted().distinct().toList());
        int largest=0, secondLargest=0, thirdLargest=0;
        for(int val:numList)
            if(val>largest){
                thirdLargest=secondLargest;
                secondLargest=largest;
                largest=val;
            }else if(val>secondLargest && val<largest){
                thirdLargest=secondLargest;
                secondLargest=val;
            }else if(val > thirdLargest && val<secondLargest){
                thirdLargest=val;
            }
        System.out.println(thirdLargest);
    }
}
