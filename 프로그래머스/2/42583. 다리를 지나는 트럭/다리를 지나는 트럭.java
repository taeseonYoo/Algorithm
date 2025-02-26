import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        
        
        int idx = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        int k = 0;
        
        q.offer(answer);
        int s = truck_weights[idx++];
        
        
        while(!q.isEmpty()){
            answer++;
    
            if((answer-q.peek())%bridge_length==0){
                q.poll();
                s -= truck_weights[k++];
            }
            
            if( idx < truck_weights.length && q.size()<=bridge_length){
                if((s+truck_weights[idx]) <= weight){
                    q.offer(answer);
                    s += truck_weights[idx++];
                }
            }
            
        }
        
        return answer;
    }
}