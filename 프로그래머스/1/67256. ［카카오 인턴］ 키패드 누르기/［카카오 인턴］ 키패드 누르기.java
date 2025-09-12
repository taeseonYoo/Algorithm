import java.util.*;

/**
키패드를 숫자로 변환한다. ex
1 2 3
4 5 6
7 8 9
10 11 12
*/

class Solution {
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int left = 10;
        int right = 12;
        
        for(int i=0;i<numbers.length;i++){
            int target = numbers[i];
            
            if(target == 1 || target == 4 || target == 7){
                left = target;
                answer.append("L");
            }else if(target == 3 || target == 6 || target == 9){
                right = target;
                answer.append("R");
            }else if(target == 2 || target == 5 || target == 8 || target == 0){
                if(target == 0) target = 11;
                
                int leftDiff = Math.abs(left-target)%3 + Math.abs(left-target)/3;
                int rightDiff = Math.abs(right-target)%3 + Math.abs(right-target)/3;
                System.out.println(target+" "+leftDiff+" "+rightDiff);
                
                if(leftDiff < rightDiff){
                    left = target;
                    answer.append("L");
                }else if(leftDiff > rightDiff){
                    right = target;
                    answer.append("R");
                }else{
                    if("left".equals(hand)){
                        left = target;
                        answer.append("L");
                    }else if("right".equals(hand)){
                        right = target;
                        answer.append("R");
                    }
                }
            }
        }
        
        
            
        return answer.toString();
    }
}