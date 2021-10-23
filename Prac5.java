//House Robber
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        
        int skip = 0;
        int choose = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int prevSkip = skip;
            skip = Math.max(skip,choose);
            choose = prevSkip + nums[i];
        }
        return Math.max(skip, choose);
    }
}
//Coin Change
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0) {
           return 0;
       }
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 0;
        for(int i = 1; i < dp[0].length; i++) {
            dp[0][i] = amount + 1;
        }
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j - coins[i-1]] + 1 , dp[i-1][j]);
                }
            }
        }
        if(dp[coins.length][amount] == amount + 1) {
            return -1;
        }
        return dp[coins.length][amount];
    }
}