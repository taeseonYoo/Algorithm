import java.util.*;
class Solution {
    List<int []> answer = new ArrayList<>();
    public int[][] solution(int n) {
        
        hanoi(n,1,2,3);
        
        
        return answer.toArray(new int[answer.size()][2]);
    }
    public void hanoi(int n,int start,int middle,int target){
        if(n==0) return;
        
        hanoi(n-1,start,target,middle);
        answer.add(new int[]{start,target});
        hanoi(n-1,middle,start,target);
    }
}