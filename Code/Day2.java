// Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

// Example 1:

// Input: nums = [1,2,3,1], k = 3, t = 0
// Output: true
// Example 2:

// Input: nums = [1,0,1,1], k = 1, t = 2
// Output: true
// Example 3:

// Input: nums = [1,5,9,1,5,9], k = 2, t = 3
// Output: false
//  Hint #1  
// Time complexity O(n logk) - This will give an indication that sorting is involved for k elements.
// Hint #2  
// Use already existing state to evaluate next state - Like, a set of k sorted numbers are only needed to be tracked. When we are processing the next number in array, then we can utilize the existing sorted state and it is not necessary to sort next overlapping set of k numbers again.


// solution

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> HT= new TreeSet<>();
        
        
        for(int i=0;i<nums.length;i++) {
            
            int T = nums[i];
            
            if(HT.floor(T)!=null && T<=HT.floor(T)+t) {
                return true;
            }
            
            if(HT.ceiling(T) !=null && T>=HT.ceiling(T)-t) {
                return true;
            }
            
            
            
            HT.add(T);
            
            if(i>=k) {
                HT.remove(nums[i-k]);
            }
            
        }
        
        return false;
    }
}