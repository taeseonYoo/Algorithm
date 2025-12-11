import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        ArrayList<ArrayList<Integer>> network = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            network.add(new ArrayList<Integer>());
        }
        
        for(int[] wire : wires){
            int start = wire[0];
            int end = wire[1];
            network.get(start).add(end);
            network.get(end).add(start);
        }
        
        for(int i=0;i<wires.length;i++){
            int[] wire = wires[i];
            int start = wire[0];
            int end = wire[1];
            boolean[] visited = new boolean[n+1];
            network.get(start).remove(Integer.valueOf(end));
            network.get(end).remove(Integer.valueOf(start));
            answer = Math.min(answer,Math.abs(n-2*bfs(1,visited,network)));
            network.get(start).add(Integer.valueOf(end));
            network.get(end).add(Integer.valueOf(start));
        }
        
        return answer;
    }
    
    int bfs(int start,boolean[] visited ,ArrayList<ArrayList<Integer>> network){
        
        Queue<Integer> q = new LinkedList<>();
        
        int count = 1;
        q.offer(start);
        
        visited[start] = true;
        
        while(!q.isEmpty()){
            int poll = q.poll();
            
            for(int i=0;i<network.get(poll).size();i++){
                int target = network.get(poll).get(i);
                if(!visited[target]) {
                    visited[target] = true;
                    q.offer(target);
                    count++;
                }
            }
        }
        return count;
    }
}