import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        //이전 위치를 기억하기 위해 Map을 사용한다.
        Map<Character,Integer> map = new HashMap<>();
        
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            //처음 나온 글자가 아니라면 현재 위치와의 인덱스 차이만큼 저장
            if(map.containsKey(ch)){
                answer[i] = i-map.get(ch);
            }else{
                answer[i] = -1;
            }
            //현재 인덱스에 있는 값의 인덱스를 저장한다. 
            //항상 가까운 인덱스 번호만 출력할 수 있도록한다.
            map.put(ch,i);
        }
        
        return answer;
    }
}