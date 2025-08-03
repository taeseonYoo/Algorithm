import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        int answer = 0, idx = 0;
        
        //보조 컨테이너
        Stack<Integer> st = new Stack<>();
        
        //메인 컨테이너의 박스
        for(int i=1; i<=order.length; i++){
            
            //메인 컨테이너와 주문이 일치한다면, answer++, inx++
            if(i==order[idx]){
                answer++;
                idx++;
            }else{
                st.add(i);
            }
            
            //stack이 비어있지 않다면, 주문과 일치하는 지 확인
            while(!st.isEmpty() && st.peek() == order[idx]){
                st.pop();
                answer++;
                idx++;
            }            
        }
        return answer;
    }
}