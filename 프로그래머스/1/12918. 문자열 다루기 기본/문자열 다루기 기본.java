class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        
        if(s.length() !=4 && s.length() != 6) {
            return false;
        }
        
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i);
            
            if(ch < 48 || ch > 57){
                
                return false;
            }
            
        }
        
        return answer;
    }
}