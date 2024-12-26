import java.util.*;
class Solution {
    public String solution(String s) {
        
    
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(ch == ' '){
                isFirst = true;
                sb.append(ch);
                continue;
            }
            
            if(isFirst){
                ch = Character.toUpperCase(ch);
                isFirst = false;
            }else{
                ch = Character.toLowerCase(ch);
            }
            
            sb.append(ch);
            
        }
        
        return sb.toString();
    }
}