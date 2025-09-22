class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0;i<schedules.length;i++){
            boolean isLate = false;
            
            schedules[i] = calculateTime(schedules[i]);
            
            for(int j=0;j<timelogs[i].length;j++){
                //현재 요일을 나타낸다. 6이면 토요일 0이면 일요일
                int currentDay = (startday+j) % 7; 
                
                //주말은 무시한다.
                if(currentDay == 0 || currentDay == 6) continue;

                //출근 희망 시간에 늦는다면, 탐색을 종료
                if(timelogs[i][j] > schedules[i]) {
                    isLate = true;
                    break;
                }
            }
            
            if(!isLate) {
                answer++;
            }
            
        }
        return answer;
    }
    
    public int calculateTime(int time){
        int hour = time/100;
        int minute = time%100;
        minute += 10;
            
        if(minute >=60){
            hour += 1;
            minute -= 60;
        }
        return hour*100 + minute;
    }
    
}