class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0;i<schedules.length;i++){
            
            int hour = schedules[i]/100;
            int minute = schedules[i]%100;
            minute += 10;
            
            if(minute >=60){
                hour += 1;
                minute -= 60;
            }
            
            int day = startday-1;
            boolean flag = false;
            
            for(int j=0;j<timelogs[i].length;j++){
                //주말은 무시한다.
                if(day == 5 || day == 6) {
                    day = (day+1)%7;
                    continue;
                }
                int rHour = timelogs[i][j]/100;
                int rMinute = timelogs[i][j]%100;
                
                if( rHour == hour && rMinute > minute){
                    flag = true;
                    break;
                }else if(rHour > hour){
                    flag = true;
                    break;
                }
                day = (day+1)%7;
            }
            if(!flag) {
                answer++;
                
            }
        }
        
        
        return answer;
    }
}