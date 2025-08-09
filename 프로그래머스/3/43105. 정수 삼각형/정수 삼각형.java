class Solution {
    
    int[][] dp;
    public int solution(int[][] triangle) {
        
        int[][] dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0];
        
        //층
        for(int i=1;i<triangle.length;i++){
            
            for(int j=0;j<=i;j++){
                if(j > 0){
                    dp[i][j] = Math.max(dp[i-1][j-1]+triangle[i][j],dp[i][j]);
                }
                
                if(j != i){
                    dp[i][j] = Math.max(dp[i-1][j]+triangle[i][j],dp[i][j]);
                }
            }
        }
        
        int result = 0;
        for(int i=0;i<triangle.length;i++){
            result = Math.max(result,dp[triangle.length-1][i]);
        }
        
        return result;
    }
}