class Solution {
    int[][] map;
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        
        map = new int[n+1][n+1];
        
        int[][] op = {{1,0},{0,1},{-1,-1}};
        int idx = 0;
        
        int num = 1;
        int x = 0;
        int y = 1;
        for(int j=n;j>=1;j--){
            for(int i=1;i<=j;i++){
                x = x + op[idx][0];
                y = y + op[idx][1];
                map[x][y] = num++;
            }
            
            idx = (idx == 2) ? 0 : (idx+1);
        }
        
        int g=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                answer[g++] = map[i][j];
            }
        }
        
        
        return answer;
    }
}