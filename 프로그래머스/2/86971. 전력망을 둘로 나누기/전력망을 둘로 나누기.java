import java.util.*;

class Solution {
    boolean[][] edges;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        edges = new boolean[n+1][n+1];
        
        
        for(int[] wire : wires){
            int start = wire[0];
            int end = wire[1];
            edges[start][end] = true;
            edges[end][start] = true;
        }
        
        for(int i=0;i<wires.length;i++){
            int[] wire = wires[i];
            int start = wire[0];
            int end = wire[1];
            visited = new boolean[n+1];
            
            edges[start][end] = false;
            edges[end][start] = false;
            
            int count = bfs(1);
            answer = Math.min(answer,Math.abs((n-count)-count));
            
            edges[start][end] = true;
            edges[end][start] = true;
        }
        
        return answer;
    }
    
    int bfs(int start){
        
        Queue<Integer> q = new LinkedList<>();
        
        int count = 1;
        q.offer(start);
        
        visited[start] = true;
        
        while(!q.isEmpty()){
            int poll = q.poll();
            
            for(int i=1;i<edges.length;i++){
                if(edges[poll][i] && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        return count;
    }
}