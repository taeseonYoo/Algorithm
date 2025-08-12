import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        char[] alphabet = s.toCharArray();
        
        Arrays.sort(alphabet);
        
        for(int i=0;i<alphabet.length;i++){
            answer.append(alphabet[alphabet.length-i-1]);
        }
        
        return answer.toString();
    }
}