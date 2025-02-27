import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        
        if(arr.length==1){
            answer.add(-1);
            return answer;
        }
        
        int min = arr[0];
        for(int a:arr){
            min = a<min ? a : min;
            answer.add(a);
        }
        
        answer.remove(new Integer(min));
        return answer;
    }
}