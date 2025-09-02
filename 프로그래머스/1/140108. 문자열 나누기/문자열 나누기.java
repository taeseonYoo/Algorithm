class Solution {
    public int solution(String s) {
        int answer = 0;
        
        //문자열 s의 인덱스를 나타냄.
        int idx = 0;
        
        while(idx < s.length()){
            //xNum은 첫글자, oNum은 첫글자와 다른 글자의 수
            int xNum = 1;
            int oNum = 0;
            
            //첫 글자 = x
            char x = s.charAt(idx++);
            
            while(xNum != oNum && idx<s.length()){
                //첫 글자 다음 숫자
                char target = s.charAt(idx++);
                if(target==x){
                    xNum++;
                }else{
                    oNum++;
                }
            }
            answer++;
        }
        
        return answer;
    }
}