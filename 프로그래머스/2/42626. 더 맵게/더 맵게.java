import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1,o2));
        
        for(int scov : scoville){
            q.offer(scov);
        }
        
        while(true){
            
            if(q.peek()>=K){
                break;
            }
            if(q.size()<2) return -1;
            
            int a = q.poll();
            int b = q.poll();
            
            int c = a+ (b*2);
            
            q.offer(c);
            answer++;
            
            
        }
        
        return answer;
    }
}