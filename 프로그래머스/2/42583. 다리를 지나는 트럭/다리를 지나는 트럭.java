import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        
        Queue<Integer> q = new LinkedList<>();
        
        int passIdx = 0;
        int moveIdx = 0;
        
        q.offer(time);
        int curWeight = truck_weights[moveIdx++];
        
        
        while(!q.isEmpty()){
            time++;
    
            if((time-q.peek())%bridge_length==0){
                q.poll();
                curWeight -= truck_weights[passIdx++];
            }
            
            if( moveIdx < truck_weights.length &&
               q.size()<=bridge_length && (curWeight+truck_weights[moveIdx]) <= weight){
                q.offer(time);
                curWeight += truck_weights[moveIdx++];
            }
            
        }
        
        return time;
    }
}