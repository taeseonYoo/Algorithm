//한 번에 한 명의 유저를 신고
//동일한 유저 여러번 신고 -> 1회로 처리
//k번 이상 신고된 유저는 정지 -> 신고한 유저에게 메일 발송
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        //신고 한 사람, 신고 받은 사람 목록 저장
        HashMap<String,HashSet<String>> reporterMap = new HashMap<>();
        
        //신고 받은 사람, 신고 받은 횟수 저장
        HashMap<String,Integer> reportCount = new HashMap<>();
        
        for(String r : report){
            String reporter = r.split(" ")[0];
            String reported = r.split(" ")[1];
            
            //신고 된 적이 없다면, Set을 추가한다.
            if(reporterMap.containsKey(reporter)){
                //중복 신고가 아니라면, 신고 받은 횟수를 증가시켜야한다.
                if(!reporterMap.get(reporter).contains(reported)){
                    reportCount.put(reported,reportCount.getOrDefault(reported,0)+1);
                }
            }else{
                reporterMap.put(reporter,new HashSet<>());
                //신고 받은 횟수를 증가시킨다.
                reportCount.put(reported,reportCount.getOrDefault(reported,0)+1);
            }   
            reporterMap.get(reporter).add(reported);
        }
        
        for(String reported : reportCount.keySet()){
            if(reportCount.get(reported) >= k){
                //메일을 발송한다.
                for(int i=0;i<id_list.length;i++){
                    if(reporterMap.get(id_list[i])==null) continue;
                    if(reporterMap.get(id_list[i]).contains(reported)){
                        answer[i]++;
                    }
                }
            }
        }
        
        
        return answer;
    }
}