class Solution {
    static int solve(int m, int n, int x, int sum,int[][] dp) {
        
        if(sum == x && n == 0)  return 1;
        if(n <= 0 || sum > x) return 0;
        
        if(dp[n][sum] != -1) return dp[n][sum];
        
        int ans = 0;
        for(int i=1; i<=m; i++){
            ans += solve(m,n-1,x,sum+i,dp);
        }
        
        return dp[n][sum] = ans;
        
        
    }
    
    static int noOfWays(int m, int n, int x) {
        int[][] dp = new int[n+1][x+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return solve(m,n,x,0,dp);
    }
};
