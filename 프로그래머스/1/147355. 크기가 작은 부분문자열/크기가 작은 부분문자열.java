class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        

        //p의 길이와 동일한 p의 부분 문자열을 비교해야하므로, 범위는 t의 길이에서 p의 길이를 뺀 곳까지 탐색한다.
        for(int i=0; i <= t.length()-p.length();i++){
            
            String target = t.substring(i, i+p.length());
            
            if(target.compareTo(p)<=0) answer++;
        }
        
        return answer;
    }
}