class Solution {
    
    String[] name = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
    int[] day = {31,29,31,30,31,30,31,31,30,31,30,31};
    
    public String solution(int a, int b) {
        String answer = "";
        
        int count = 0;
        //월별 일자를 종합한다.
        for(int i=0;i<a-1;i++){
            count += day[i];
        }
        //일별 일자를 종합한다.
        count += (b-1);
        
        answer = name[(count + 5)%7];
        
        return answer;
    }
}