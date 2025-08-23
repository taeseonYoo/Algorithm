
/**
1. 아이디어 
약수의 개수를 구하는 함수를 작성한다.
약수의 개수와 limit를 비교한다.
2. 범위
O(N * 루트 N)
*/
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        
        
        for(int i=2;i<=number;i++){
            int count = divisor(i);
            
            
            answer += count<=limit ? count : power;
        }
        
        return answer;
    }
    
    //약수의 개수를 반환하는 메서드
    public int divisor(int num){
        int count = 0;
        for(int i=1;i*i<=num;i++){
            
            if(i*i==num)count++;
            else if(num%i==0) count+=2;
        }
        return count;
    }
}