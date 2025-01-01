import java.util.*;

class Solution {
    int[] result = new int[3];
    public List<Integer> solution(int[] answers) {
        
        List<Integer> answer = new ArrayList<>();
        
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i=0;i<answers.length;i++){
            if(num1[i%num1.length]==answers[i])
                result[0]++;
            if(num2[i%num2.length]==answers[i])
                result[1]++;
            if(num3[i%num3.length]==answers[i])
                result[2]++;        
        }
       
        int max = 0;
        for(int i=0;i<3;i++){
            max = Math.max(max,result[i]);
        }
        for(int i=0;i<3;i++){
            if(max == result[i]){
                answer.add(i+1);
            }
        }
        
        
        return answer;
    }
}

