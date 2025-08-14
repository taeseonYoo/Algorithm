class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        // 1. 3진법으로 변환 + sb에 역순으로 저장
        while(n>0){
            sb.append(n%3);
            n /= 3;
        }
        
        // 2. 10진법으로 변환
        answer = Integer.parseInt(sb.toString(),3);
        
        return answer;
    }
}