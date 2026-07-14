class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            if (!dp[i]) {
                continue;
            }
            int maxJump = nums[i];
            for (int j = 1; j <= maxJump; j++) {
                if (i+j >= nums.length) {
                    return true;
                }
                dp[i+j] = true;
            }
        }

        return dp[nums.length-1];
    }
}