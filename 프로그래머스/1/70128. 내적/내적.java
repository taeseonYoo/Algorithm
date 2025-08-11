/**
* 값을 저장하는 answer에는 최대 10억이 저장되므로 int 범위 내에서 가능하다.
**/

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i=0;i<a.length;i++){
            answer += a[i]*b[i];
        }
        
        return answer;
    }
}