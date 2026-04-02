import java.util.Arrays;


public class PlusOne {
    public static void main(String[] args) {
        int numList[] = {9,9,9,9};
        int carry=1;
        for(int i=numList.length-1;i>=0;i--){
            int sum=numList[i]+carry;
            numList[i]=sum%10;
            carry=sum/10;
        }
        if(carry>0){
            int newArr[]=new int[numList.length+1];
            newArr[0]=carry;
            System.arraycopy(numList, 0, newArr, 1, numList.length);
            Arrays.stream(newArr).forEach(System.out::print);
            return;
        }
        Arrays.stream(numList).forEach(System.out::print);
    }
}
