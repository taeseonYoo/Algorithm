class Solution {
    boolean[] visited;
    int[][] computersX;
    int nx;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        computersX = computers;
        nx = n;
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    public void dfs(int x){
        
        visited[x]=true;
        for(int i=0;i<nx;i++){
            int a = computersX[x][i];
            if(a == 1 && i != x){
                if(!visited[i]){
                    dfs(i);
                }
            }
        }
    }
}