class Solution {
    public int solution(String s) {
        int answer = 0;
        
        answer = s.charAt(0)=='-' ? -Integer.parseInt(s.substring(1)) : Integer.parseInt(s.substring(0));
        
        return answer;
    }
}