/**
1. 아이디어
발음을 배열에 저장해둔다.
replace로 해당 문자를 빈배열로 대체한다.
만약 최종이 빈 문자열이라면 result++
*/
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] owng = {"aya","ye","woo","ma"};
        
        for(int i=0;i<babbling.length;i++){
            
            String target = babbling[i];
        
            for(int j=0;j<owng.length;j++){
                //연속 발음 검증
                String sound = owng[j] + owng[j];
                if(target.contains(sound)) break;
                target = target.replace(owng[j]," ");
            }
            
            if("".equals(target.trim())) answer++;
        }
        
        
        
        return answer;
    }
}