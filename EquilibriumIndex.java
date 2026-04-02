class EquilibriumIndex{
    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        int pivot=-1, totalSum=0, leftSum=0;
        for(int num:arr)totalSum+=num;

        for(int i=0;i<arr.length;i++){
            if(totalSum-leftSum-arr[i]==leftSum){
                pivot=i;
                break;
            }
            leftSum+=arr[i];
        }
        System.out.println(pivot);

    }
}