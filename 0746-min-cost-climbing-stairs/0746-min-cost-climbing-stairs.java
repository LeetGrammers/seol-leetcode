class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;

        if (len == 2) {
            return Math.min(cost[0], cost[1]);
        }

        // dp[i] : i번째 계단까지 오는데 필요한 최소비용
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len-1; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i], dp[i-2] + cost[i]);
        }
        dp[len-1] = Math.min(dp[len-2], dp[len-3] + cost[len-1]); // 바로 전 한칸에서 두칸 뛰어서 마지막 계단 안밟고 top으로 가는 경우, 두칸 전에서 마지막 계단 밟고 top 가는 경우
        return dp[len-1];
    }
}