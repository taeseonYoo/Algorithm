class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(computers,n,i);
                answer++;
            }
        }
        
        return answer;
    }
    public void dfs(int[][] computers,int n,int x){
        
        visited[x]=true;
        
        for(int i=0;i<n;i++){
            int a = computers[x][i];
            if(a == 1 && !visited[i]){
                dfs(computers,n,i);
            }
        }
    }
}