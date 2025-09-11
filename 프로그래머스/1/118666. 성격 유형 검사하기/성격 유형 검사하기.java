import java.util.*;

class Solution {
    
    
    
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        
        char[] type = {'R','T','C','F','J','M','A','N'};
        
        Map<Character, Integer> mp = new HashMap<>();
        
        for(int i=0;i<8;i++){
            mp.put(type[i],0);
        }
        
        
        for(int i=0;i<survey.length;i++){
            char n = survey[i].charAt(0); //비동의 항목
            char y = survey[i].charAt(1); // 동의 항목
            
            int choice = choices[i];
            
            if(choice == 4){
                continue;
            }else if(choice < 4){ //비동의 항목
                int num = 4-choice;
                mp.put(n,mp.get(n)+num);
            }else if(choice > 4){ //동의 항목
                int num = choice-4;
                mp.put(y,mp.get(y)+num);
            }
        }
        
        for(int i=0;i<8;i=i+2){
            if(mp.get(type[i])>= mp.get(type[i+1])){
                answer.append(type[i]);
            }else{
                answer.append(type[i+1]);
            }
        }
        
    
        return answer.toString();
    }
}