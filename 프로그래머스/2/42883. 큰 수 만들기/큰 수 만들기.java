import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        //자릿수
        int num = number.length()-k;

        int start=0;

        while(answer.length()<num){
            int last = k+1+answer.length();
            int max = 0;
            for(int i=start;i<last;i++){ //최대값 찾기
                if(max < number.charAt(i)-'0'){
                    max = number.charAt(i)-'0';
                    start=i+1;
                }
            }
            answer.append(max);
        }
        
        
        
        return answer.toString();
    }
}