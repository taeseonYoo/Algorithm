import java.util.*;

/**
k는 최대 사과품질
m은 포장 사과 개수
사과 품질을 정렬해서, 좋은 품질부터 담으면 최대값
*/
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        for(int i=score.length-m;i>=0;i-=m){
            answer += score[i] * m ;
        }
           
        return answer;
    }
}