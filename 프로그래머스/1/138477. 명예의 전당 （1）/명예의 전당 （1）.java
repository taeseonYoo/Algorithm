import java.util.*;

/**
* 1. 아이디어 
우선순위 큐를 사용해서 자동으로 정렬되도록 한다.
*/
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        //명예의 전당 리스트
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<score.length;i++){
            //명예의 전당에 스코어를 입력한다.
            pq.add(score[i]);
            
            //상위 k보다 인원이 많다면 가장 score가 적은 기록을 제거한다.
            if(pq.size() > k){
                pq.remove();
            }
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}