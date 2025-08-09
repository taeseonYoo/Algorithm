import java.util.*;

class Solution {
    
    int[][] dp;
    public int solution(int[][] triangle) {
        
        int[][] dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0];
        
        //층
        for(int i=1;i<triangle.length;i++){
            
            for(int j=0;j<=i;j++){
                //오른쪽 끝에 있는 경우 -> 왼쪽만 
                if(i == j){
                    dp[i][j] = dp[i-1][j-1]+triangle[i][j];
                }
                else if(j == 0){ //왼쪽 끝에 있는 경우
                    dp[i][j] = dp[i-1][j]+triangle[i][j];
                }
                else{ 
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+triangle[i][j];
                }
            }
        }
        
        Arrays.sort(dp[triangle.length-1]);
        
        return dp[triangle.length-1][triangle.length-1];
    }
}