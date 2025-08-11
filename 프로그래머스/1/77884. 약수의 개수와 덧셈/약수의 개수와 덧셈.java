
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left;i<=right;i++){
            answer += decimal(i) % 2 == 0 ? i : i * -1;
        }
        
        return answer;
    }
    //소수의 개수 구하기
    public int decimal(int num){
        
        int count = 0;
        for(int i=1;i<=num;i++){
            if(num % i ==0) count++;
        }
        
        return count;
    }
}