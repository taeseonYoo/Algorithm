import java.util.*;

class Solution {
    public String solution(String new_id) {

        //1단계
        new_id = new_id.toLowerCase();
        
        //2단계
        String regex = "[^a-z0-9\\-_.]";
        new_id = new_id.replaceAll(regex,"");
        
        //3단계
        new_id = new_id.replaceAll("\\.+","\\.");
        
        //4단계
        new_id = new_id.replaceAll("^[.]|[.]$","");
        
        //5단계
        new_id = new_id.isEmpty() ? "a" : new_id;
        
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