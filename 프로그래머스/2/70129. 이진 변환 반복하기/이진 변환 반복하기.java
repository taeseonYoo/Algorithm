import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        
        
        while(!s.equals("1")){
            answer[1] += s.length();
            s = s.replace("0","");
            
            answer[0]++;
            answer[1] -= s.length();
            s = Integer.toBinaryString(s.length());
    
        }
        
        
        return answer;
    }
}