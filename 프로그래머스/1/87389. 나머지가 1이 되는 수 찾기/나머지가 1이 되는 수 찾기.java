class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int t = n-1;
        while(n>0 && t>0){
            if(n%t==1){
                answer = t;
            }
            t--;
        }
        return answer;
    }
}