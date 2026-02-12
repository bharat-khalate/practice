import java.util.*;

public class SubArrayWithKDistEle {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 1, 1, 1));
        int k = 2;
        System.out.println(getSubarrayCount(k, numList)-getSubarrayCount(k-1, numList));

    }

    public static int getSubarrayCount(int k, List<Integer>numList){
        int count=0;
        Map<Integer,Integer> freqMap=new HashMap<>();
        for(int start=0, end=0; end<numList.size();end++){
            freqMap.put(numList.get(end), freqMap.getOrDefault(numList.get(end), 0)+1);

            while (freqMap.size()>k) {
                freqMap.put(numList.get(start), freqMap.get(numList.get(start))-1);
                if(freqMap.get(numList.get(start))==0){
                    freqMap.remove(numList.get(start));
                }
                start++;                
            }

            if(freqMap.size()<=k){
                count+=end-start+1;
            }
        }
        return count;
    }

}
