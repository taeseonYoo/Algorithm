import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String,Integer> map = new HashMap<>();
        
        // (선수이름, 등수)를 저장한다.
        for(int i=0;i<players.length;i++){
            map.put(players[i], i);
        }
        
        for(String call : callings){
            
            //추월하는 플레이어 등수
            int upPlayerRank = map.get(call);
            
            //추월당한 선수의 이름
            String downPlayer = players[upPlayerRank-1];
            
            //추월당한 선수 갱신
            map.put( downPlayer , upPlayerRank);
            players[upPlayerRank] = downPlayer;
            
            //추월한 선수 갱신
            map.put( call , upPlayerRank-1);
            players[upPlayerRank-1] = call;
        }
        
        
        return players;
    }
}