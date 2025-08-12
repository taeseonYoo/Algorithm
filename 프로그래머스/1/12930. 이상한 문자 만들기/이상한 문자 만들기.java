class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        int idx = 0;
        
        for(char c : s.toCharArray()){
            //빈칸은 그대로
            if(c == ' '){
                answer.append(" ");
                idx = 0;
            }else{
                answer.append(idx % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
                idx++;
            }
        }
        
        return answer.toString();
    }
}