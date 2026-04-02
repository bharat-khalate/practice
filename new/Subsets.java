public class Subsets {
    
}
/**
 * 78. Subsets
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subSets=new ArrayList<>();
        int n=nums.length;
        for(int mask=0;mask<(1<<n);mask++){
            List<Integer> tempList=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if((mask & (1<<i))!=0){
                    tempList.add(nums[i]);
                }
            }
            subSets.add(tempList);
        }
        return subSets;
    }
}