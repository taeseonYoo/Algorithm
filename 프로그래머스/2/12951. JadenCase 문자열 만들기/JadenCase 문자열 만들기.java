import java.util.*;
class Solution {
    public String solution(String s) {
        
    
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(ch == ' '){
                flag = true;
                sb.append(ch);
                continue;
            }
            
            if(Character.isLetter(ch) && flag){
                ch = Character.toUpperCase(ch);
                
                flag = false;
            }else if (!Character.isLetter(ch) && flag){
                ch = ch;
                
                flag = false;
            }else{
                ch = Character.toLowerCase(ch);
                
            }
            
            sb.append(ch);
            
        }
        
        return sb.toString();
    }
}