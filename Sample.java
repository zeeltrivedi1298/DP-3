//prob 1 delete and earn 
// Time Complexity : O(n) + max(nums)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums== null || nums.length ==0){ return 0;}

        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }

            int n = nums.length;
            int[] dp = new int[max+1];

            for(int i=0; i<n; i++){
                int idx = nums[i];
                dp[idx] = dp[idx] + nums[i];
                
            }
            int skip = 0; int take = dp[0];
            for(int i =1 ; i< dp.length ; i++){
                int temp = skip;
                skip = Math.max(skip,take);
                take = temp + dp[i];
            }


            return Math.max(skip,take);
    
        
    }
}







//prob 2 minimum falling path sum
// Time Complexity : O(n) + max(nums)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes   
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if( matrix == null || matrix.length == 0) { return 0;}

        int n = matrix.length;

        for(int i = n-2; i>=0 ; i --){
            for(int j = 0; j < n ; j++){
                if (j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);
                }
                else if (j == n-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], Math.min( matrix[i+1][j+1], matrix[i+1][j-1]));
                }
                
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j< n; j++){
            min = Math.min(matrix[0][j], min);
        }
        return min;
    }
}
Console
