import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<works.length;i++){
            pq.offer(works[i]);
        }
        
        while(n>0){
            Integer num = pq.poll();
            num = num > 0 ? num-1 : 0;
            pq.offer(num);
            n--;
        }
        
        for(int i=0;i<works.length;i++){
            answer += Math.pow(pq.poll(),2);
        }
        
        return answer;
    }
}