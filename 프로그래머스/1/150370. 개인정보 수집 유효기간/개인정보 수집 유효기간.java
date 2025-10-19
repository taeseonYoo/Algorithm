import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<String,Integer> m = new HashMap<>();
        
        int todayDate = getDate(today);
        
        //약관의 유효기간을 terms에 담는다.
        for(String term : terms){
            String[] split = term.split(" ");
            m.put(split[0],Integer.parseInt(split[1]));
        }
        
        for(int i=0;i<privacies.length;i++){
            String[] privacy = privacies[i].split(" ");
            
            int privacyDate = getDate(privacy[0]) + m.get(privacy[1])*28;
            if(privacyDate <= todayDate){
                answer.add(i+1);
            }
        }
        
        return answer;
    }
    
    private int getDate(String date) {
        String[] split = date.split("\\.");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}