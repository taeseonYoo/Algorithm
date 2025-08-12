import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for(int money : d){
            if(money<=budget){
                answer++;
                budget -= money;
            }
        }
        
        return answer;
    }
}