import java.util.*;
import java.io.*;
class Solution {
    
    public char[] op = {'(','[','{'};
    public char[] cl = {')',']','}'};
    
    public int solution(String s) {
        int answer = 0;
        
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            
            boolean possible = true;
            //회전
            if(i!=0){
                char w = s.charAt(0);
                s = s.substring(1) + w;
            }
            
            
            //판별
            
            for(int j=0;j<s.length();j++){
                
                char comp = s.charAt(j);
                
                if(comp == op[0] || comp == op[1] || comp == op[2] ){
                    st.push(comp);
                }else{
                    //닫힌 거라면 스택에서 꺼내서 비교
                    if(st.empty()){
                        possible = false;
                        break;
                    } 
                    
                    char cls = st.peek();
                    
                    int q=0;
                    for(q = 0;q<3;q++){
                        if(cls == op[q]){
                            break;
                        }
                    }
                    int p=0;
                    for(p = 0;p<3;p++){
                        if(comp == cl[p]){
                            break;
                        }
                    }
                    if(p==q){
                        st.pop();
                    }else{
                        possible=false;
                        break;
                    }
                    
                }
                
            }
            if(!st.empty()) possible = false;
            
            if(possible)answer++;
        
            
        }
        return answer;
    }
}