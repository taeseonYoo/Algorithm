import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Stack<Character> st = new Stack<>();
        
        st.push(s.charAt(0));
        
        for(int i=1;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(st.isEmpty()){
                st.push(ch);
                continue;
            }
            
            if(st.peek()==ch){
                st.pop();
            }else{
                st.push(ch);
            }
            
        }
        
        answer = st.isEmpty() ? 1 : 0;
        return answer;
    }
}