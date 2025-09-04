/**
1. 아이디어
자릿수가 300만개 이므로 이중 포문을 돌면 시간 초과 발생
Y의 각 자리 숫자를 10칸의 배열에 저장한다.

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
        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<answer.size();i++){
            sb.append(answer.get(i));
        }
        
        String result = sb.toString();
        
        if(result.equals(""))return "-1";
        else if(result.startsWith("0")) return "0";
        
        return result;
    }
}