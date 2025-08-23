
/**
1. 아이디어
2진수로 변환한 뒤 비트 연산을 사용한다.
*
**/
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            //앞에 0이 부족한 경우
            while(answer[i].length()<n){
                answer[i] = "0" + answer[i];
            }
            
            answer[i] = answer[i].replace("1","#").replace("0"," ");
        }
        
        
        
        return answer;
    }
}