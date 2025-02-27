import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        if(arr.length==1){
            answer.add(-1);
            return answer;
        }
        
        for(int a:arr){
            answer.add(a);
        }
        
        answer.remove(Collections.min(answer));
        return answer;
    }
}