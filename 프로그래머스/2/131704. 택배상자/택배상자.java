import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        //보조 컨테이너 벨트
        Stack<Integer> st = new Stack<>();
        
        int box = 1;
        int idx = 0;
        
        while(box<=order.length){
            
            if(box == order[idx]){
                box++;
                idx++;
            }else if(!st.isEmpty() && st.peek() == order[idx]){
                idx++;
                st.pop();
            }else{
                st.push(box++);
            }
        }
        
        while(!st.empty() && st.peek()==order[idx] && idx < order.length){
            st.pop();
            idx++;
        }
        
        return idx;
    }
}