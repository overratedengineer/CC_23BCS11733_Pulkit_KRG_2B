import java.util.*;

class Solution {
    /* Function to find the longest increasing 
    subsequence in the given array */
    public int LIS(int[] nums) {
        int n = nums.length;
        
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        
        // Iterate on the elements of the array
        for (int i = 1; i < n; i++) {
            
            // If the current element can be added to the subsequence
            if (nums[i] > temp.get(temp.size() - 1)) 
                temp.add(nums[i]); 
                
            // Otherwise
            else {
                // Index at which the current element must be placed
                int ind = Collections.binarySearch(temp, nums[i]);
                if (ind < 0) ind = -(ind + 1);
                
                // Place the current element in the subsequence
                temp.set(ind, nums[i]);
            }    
        }
        
        // Return the length of temporary subsequence created so far
        return temp.size();
    }
}

class LIA {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        
        // Creating an object of Solution class
        Solution sol = new Solution();
        int lengthOfLIS = sol.LIS(nums);
        
        System.out.println("The length of the LIS for the given array is: " + lengthOfLIS);
    }
}
