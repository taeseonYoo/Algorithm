class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String tmp = s;
        
        int idx = 0;
        while(idx < tmp.length()){
            int xNum = 0;
            int oNum = 0;
            
            char x = tmp.charAt(idx++);
            xNum++;
            
            while(xNum != oNum && idx<tmp.length()){
                char target = tmp.charAt(idx++);
                if(target==x){
                    xNum++;
                }else{
                    oNum++;
                }
            }
            answer++;
        }
        
        return answer;
    }
}