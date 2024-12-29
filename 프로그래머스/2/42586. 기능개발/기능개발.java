import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            
            int progress = (100-progresses[i]);
            
            int result = progress%speeds[i]==0 ? progress/speeds[i] : (progress/speeds[i]) + 1;
        
            
            q.offer(result);
        }
        
        
        while(!q.isEmpty()){
            
            int count = 1;
            int target = q.poll();
            
            while(!q.isEmpty()){
                int next = q.peek();
                
                if(next<=target){
                    count++;
                    q.poll();
                }else{
                    break;
                }
            }
            answer.add(count);
            
        }
        
        return answer;
    }
}