class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a>b){
            int tmp = a;
            a = b;
            b = tmp;
        }
    
        
        while(a<=b){
            answer+=a;
            a++;
        }
        return answer;
    }
}