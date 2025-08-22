import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        //명예의 전당 리스트
        List<Integer> own = new ArrayList<>();
        
        int i=0;
        for(int s:score){
            own.add(s);
            
            Collections.sort(own);
            //명예의 전당에서 k번째 값을 찾는다.
            answer[i++] = own.size() < k ? own.get(0) : own.get(own.size()-k);
        }
        
        return answer;
    }
}