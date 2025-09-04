/**
1. 아이디어
X를 기준으로 for문을 실행
Y에 contains 함수로 해당 문자가 존재하는 지 확인한다.
Y에서 찾은 가장 첫번째 문자를 숫자가 아닌 문자로 변환한다.(ex.*)

*/
import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        //숫자가 몇번 나왔는 지 확인한다.
        int[] numbers = new int[10];
       
        for(int i=0;i<Y.length();i++){
            char ch = Y.charAt(i);
            
            numbers[ch-'0']++;
        }
        
        List<Character> answer = new ArrayList<>();
        
        //X를 순회하며 비교한다.
        for(char ch : X.toCharArray()){
            if(numbers[ch-'0']>0){
                answer.add(ch);
                numbers[ch-'0']--;
            }
        }
        
        Collections.sort(answer,Collections.reverseOrder());
        
        if(answer.isEmpty()) return -1+"";
        else if(answer.get(0)=='0') return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<answer.size();i++){
            sb.append(answer.get(i));
        }
        
        return sb.toString();
    }
}