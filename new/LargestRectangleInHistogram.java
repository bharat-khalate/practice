package new;
/**
 * 84. Largest Rectangle in Histogram
Solved
Hard
Topics
premium lock icon
Companies
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
 */
public class LargestRectangleInHistogram {
    
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int arr[]=new int[n+1];
        System.arraycopy(heights,0,arr,0,n);
        arr[n]=0;
        int area=0;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                int height=arr[stack.pop()];
                int width=stack.isEmpty()?i:i-stack.peek()-1;
                area=Math.max(area,height*width);
            }
            stack.push(i);
        }
        return area;

    }
}



739. Daily Temperatures
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

 

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
 

Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100