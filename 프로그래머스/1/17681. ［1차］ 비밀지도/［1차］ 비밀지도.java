
/**
1. 아이디어
2진수로 변환한 뒤 비트 연산을 사용한다.
*
**/
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<arr1.length;i++){
            String a = Integer.toBinaryString(arr1[i]);
            String b = Integer.toBinaryString(arr2[i]);
            
            while(a.length()<n){
                a = "0" + a;
            }
            while(b.length()<n){
                b = "0" + b;
            }
            
            String tmp = "";
            for(int j=0;j<n;j++){
                if(a.charAt(j)=='0' && b.charAt(j)=='0'){
                    tmp += " ";
                }else{
                    tmp += "#";
                }
            }
            answer[i] = tmp;
        }
        
        
        return answer;
    }
}