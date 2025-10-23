import java.util.*;
class Solution {
    List<int []> answer;
    public int[][] solution(int n) {
        answer = new ArrayList<>();
        
        hanoi(n,1,2,3);
        
        int[][] result = new int[answer.size()][2];
        
        for(int i=0;i<result.length;i++){
            result[i] = answer.get(i);
        }
        
        return result;
    }
    public void hanoi(int n,int start,int middle,int target){
        if(n==0) return;
        
        hanoi(n-1,start,target,middle);
        answer.add(new int[]{start,target});
        hanoi(n-1,middle,start,target);
    }
}