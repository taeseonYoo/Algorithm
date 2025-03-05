class Solution {
    
    int[][] map;
    int[][] op = {{1,0},{0,1},{-1,-1}};
    
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        
        map = new int[n+1][n+1];
        
        int idx = 0, num=1;
        
        int x = 0;
        int y = 1;
        for(int step=n;step>=1;step--){
            
            for(int i=1;i<=step;i++){
                x = x + op[idx][0];
                y = y + op[idx][1];
                map[x][y] = num++;
            }
            
            idx = (idx+1)%3;
        }
        
        int index=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                answer[index++] = map[i][j];
            }
        }
        
        
        return answer;
    }
}