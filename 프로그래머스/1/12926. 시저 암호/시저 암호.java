class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(ch == ' '){
                answer.append(" ");
            }else if(ch <= 90 && ch >= 65){ //대문자인 경우
                answer.append(String.valueOf((char)((ch - 65 +n)% 26 + 65)));
            }else{ //소문자인 경우
                answer.append(String.valueOf((char)((ch - 97 +n)% 26 + 97)));
            }
            
        }
    
        return answer.toString();
    }
}