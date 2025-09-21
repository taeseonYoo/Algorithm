import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        //1단계
        for(int i=0;i<new_id.length();i++){
            char ch = new_id.charAt(i);
            
            if(Character.isUpperCase(ch)){
                sb.append(Character.toLowerCase(ch));
            }else sb.append(ch);
        }
        //2단계
        String regex = "[^a-z0-9\\-_.]";
        new_id = sb.toString().replaceAll(regex,"");
        
        //3단계
        new_id = new_id.replaceAll("\\.+","\\.");
        
        //4단계
        if(new_id.length()>0){
            if(new_id.charAt(0)=='.') new_id = new_id.substring(1);
        }
        if(new_id.length()>0){
            if(new_id.charAt(new_id.length()-1)=='.') new_id = new_id.substring(0,new_id.length()-1);
        }
        
        //5단계
        if("".equals(new_id)) new_id = "a";
        
        //6단계
        if(new_id.length()>=16) {
            new_id = new_id.substring(0,15);
            if(new_id.charAt(new_id.length()-1)=='.') new_id = new_id.substring(0,new_id.length()-1);
        }
        
        
        //7단계
        if(new_id.length()<=2){
            char ch = new_id.charAt(new_id.length()-1);
            while(new_id.length()<3) new_id = new_id + ch;
        }
        
        
        return new_id;
    }
}