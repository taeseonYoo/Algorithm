import java.util.*;

class Solution {
    
    public class Node implements Comparable<Node>{
    private int distance;
    private int index;
    
    public Node(int index,int distance){
        this.distance = distance;
        this.index = index;
    }
    public int getDistance(){
        return distance;
    }
    public int getIndex(){
        return index;
    }
    @Override
    public int compareTo(Node other){
        if(this.distance < other.distance){
            return -1;
        }
        return 1;
    }
        
    }
    
    public final int INF = (int)1e9;
    public ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public int[] d = new int[51];
    public int n;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<Node>());
        }
        for(int i=0;i<road.length;i++){
            int [] p = road[i];
            graph.get(p[0]).add(new Node(p[1],p[2]));
            graph.get(p[1]).add(new Node(p[0],p[2]));
        }
        
        Arrays.fill(d,INF);
        
        dijkstra();
        
        for(int i=1;i<=N;i++){
            if(d[i]<=K){
                answer++;
            }
        }
    

        return answer;
    }
    
    public void dijkstra(){
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(1,0));
        d[1]=0;
        
        while(!pq.isEmpty()){
            
            Node node = pq.poll();
            int dist = node.getDistance();
            int idx = node.getIndex();
            
            if(d[idx]<dist) continue;
            
            for(int i=0;i<graph.get(idx).size();i++){
                
                int cost = graph.get(idx).get(i).getDistance() + d[idx];
                
                if(cost< d[graph.get(idx).get(i).getIndex()]){
                    d[graph.get(idx).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(idx).get(i).getIndex(),cost));
                }
            }
        }
    }
    
    
    
    
}
