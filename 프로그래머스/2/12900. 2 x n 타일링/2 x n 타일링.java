class Solution {
    
    int[] tile;
    final int MAX_VALUE = 1000000007;
    public int solution(int n) {
        int answer = 0;
        
        tile = new int[n+1];
        
        tile[1] = 1;
        tile[2]= 2;
        
        for(int i=3;i<=n;i++){
            tile[i] = (tile[i-2]+tile[i-1])% MAX_VALUE;
        }
        
        return tile[n];
    }
}