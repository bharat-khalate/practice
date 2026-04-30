package number;

public class Palindrome {
    public static void main(String args[]){
        int n=Math.abs(19);
        int reversed=0;
        int temp=n;
        while(temp>0){
            reversed=reversed*10+temp%10;
            temp/=10;
        }
        System.out.println(reversed==n);
    }
}
