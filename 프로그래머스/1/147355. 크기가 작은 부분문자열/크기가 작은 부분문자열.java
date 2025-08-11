class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long pNum = Long.parseLong(p);

        //p의 길이와 동일한 p의 부분 문자열을 비교해야하므로, 범위는 t의 길이에서 p의 길이를 뺀 곳까지 탐색한다.
        for(int i=0; i <= t.length()-p.length();i++){
            
            String target = t.substring(i, i+p.length());
            //t의 부분문자열을 숫자로 변환한다.
            long tNum = Long.parseLong(target);
            
            if(tNum <= pNum) answer++;
        }
        
        return answer;
    }
}