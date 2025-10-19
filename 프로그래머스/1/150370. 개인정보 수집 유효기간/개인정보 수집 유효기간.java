import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String,Integer> m = new HashMap<>();
        
        //약관의 유효기간을 terms에 담는다.
        for(String term : terms){
            String[] split = term.split(" ");
            m.put(split[0],Integer.parseInt(split[1]));
        }
        
        for(int i=0;i<privacies.length;i++){
            String[] privacy = privacies[i].split(" ");
            String date = privacy[0];
            Integer exp = m.get(privacy[1]);
            
            if(verifyPrivacyDelete(today,date,exp)){
                answer.add(i+1);
            }
        }
        
        return answer;
    }
    
    public boolean verifyPrivacyDelete(String today,String date, Integer exp){
        String[] t = today.split("\\.");
        String[] d = date.split("\\.");
        
        //오늘 날짜
        int todayYear = Integer.parseInt(t[0]);
        int todayMonth = Integer.parseInt(t[1]);
        int todayDay = Integer.parseInt(t[2]);
        
        //수집된 개인정보의 정보
        int dateYear = Integer.parseInt(d[0]);
        int dateMonth = Integer.parseInt(d[1]) + exp;
        int dateDay = Integer.parseInt(d[2]);
        
        if(dateMonth > 12){
            int year = (dateMonth-1)/12;
            dateMonth = dateMonth % 12;
            if(dateMonth == 0) dateMonth = 12;
            dateYear = dateYear + year; 
        }
        
        //파기 해야한다 == 오늘날짜보다 이전이다.
        if(dateYear<todayYear) return true;
        else if(dateYear == todayYear){
            if(dateMonth < todayMonth) return true;
            else if(dateMonth == todayMonth) {
                if(dateDay <= todayDay) return true;
            }
        }
        
        return false;
    } 
}