class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n>=a){
            
            //받게 될 콜라의 개수
            int coke = (n/a)*b;
            answer += coke;
        
            //빈 병을 제출한다.
            n = n%a;
            //새로운 콜라를 추가한다.
            n += coke;
        }
        
        return answer;
    }
}