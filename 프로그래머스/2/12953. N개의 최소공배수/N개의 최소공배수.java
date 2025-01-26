import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int a : arr){
            q.offer(a);
        }
        
        while(q.size()>1){
            int a = q.poll();
            int b = q.poll();
            
            q.offer(lcm(a,b));
        }
        answer = q.peek();
        
        return answer;
    }
    
    public int gcd(int a,int b){
        int tmp;
        while(b!=0){
            tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
    
    public int lcm(int a, int b){
        return a* (b / gcd(a,b));
    }
}