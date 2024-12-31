import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        
        
        List<Integer> list = new ArrayList<>();
        
        while(!s.equals("1")){
            int n = s.length();
            s = s.replace("0","");
            list.add(n- s.length());
            s = Integer.toBinaryString(s.length());
        }
        answer[0]= list.size();
        
        int sum=0;
        for(Integer i :list){
            sum += i;
        }
        answer[1]=sum;
        
        return answer;
    }
}