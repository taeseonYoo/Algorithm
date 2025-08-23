
/**
1. 아이디어
2진수로 변환한 뒤 비트 연산을 사용한다.
*
**/
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            String binary = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            //앞에 0이 부족한 경우
            while(binary.length()<n){
                binary = "0" + binary;
            }
            
            binary = binary.replace("1","#");
            binary = binary.replace("0"," ");
            answer[i] = binary;
        }
        
        
        
        return answer;
    }
}