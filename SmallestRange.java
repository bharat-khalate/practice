import java.util.*;

public class SmallestRange {
    public static void main(String[] args) {
        List<List<Integer>> numList = new ArrayList<>(
                List.of(List.of(2, 4), List.of(1, 7), List.of(20, 40)));
            PriorityQueue<List<Integer>> minHeap=new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
        int maxValue=0;
        for(int i=0; i<numList.size();i++){
            minHeap.offer(List.of(numList.get(i).get(0),i,0));
            maxValue=Math.max(maxValue, numList.get(i).get(0));
        }

        int rangeStart=0, rangeEnd=Integer.MAX_VALUE;

        while (true) {
           var tempList=minHeap.poll();
           int val=tempList.getFirst();
           int row=tempList.get(1);
           int col=tempList.getLast();



           if(maxValue-val < rangeEnd-rangeStart || (maxValue-val == rangeEnd-rangeStart && val<rangeEnd)){
            rangeStart=val;
            rangeEnd=maxValue;
           }


           if(col+1 == numList.get(row).size()){
            break;
           }

           int nextValue=numList.get(row).get(col+1);
           minHeap.offer(List.of(nextValue,row,col+1));
           maxValue=Math.max(maxValue, nextValue);
        }

        System.out.println(List.of(rangeStart,rangeEnd));

    }
}

         




