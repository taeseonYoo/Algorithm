class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int[] points = new int[3];
        
        int idx = -1;
        
        for(int i=0;i<dartResult.length();i++){
            
            char ch = dartResult.charAt(i);
            
            if(Character.isDigit(ch)) continue;
            
            if (ch == 'S' || ch == 'D' || ch == 'T') {
                int num;
                if (i >= 2 && dartResult.charAt(i-2) == '1' && dartResult.charAt(i-1) == '0') {
                    num = 10;
                } else {
                num = dartResult.charAt(i-1) - '0';
                }
                if (ch == 'S') points[++idx] = num;
                if (ch == 'D') points[++idx] = num*num;
                if (ch == 'T') points[++idx] = num*num*num;
            }else if(ch == '*'){
                if(idx>=1){
                    points[idx-1] *= 2;
                }
                points[idx] *= 2;
            }else if(ch == '#'){
                points[idx] *= -1;
            }
            
        }
        
        for(int i=0;i<3;i++){
            answer += points[i];
        }
        
        return answer;
    }
    
}