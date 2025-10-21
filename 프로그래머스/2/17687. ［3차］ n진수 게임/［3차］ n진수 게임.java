class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        int num = 0;
        int turn = 1;
        while(answer.length() < t){
            
            String result = Integer.toString(num++,n).toUpperCase();
            
            //튜브의 순서라면 더한다.
            for(int j=0;j<result.length();j++){
                //현재 차례
                if(turn == p){
                    answer.append(result.charAt(j));
                    if(answer.length() == t) break;
                }
                turn++;
                if(turn == m+1) turn = 1;
            }
            
        }
        
        
        return answer.toString();
    }
}