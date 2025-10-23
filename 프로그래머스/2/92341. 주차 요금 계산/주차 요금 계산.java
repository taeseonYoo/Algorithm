import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 차량 번호, 출차 기록
        Map<String,Integer> parkingRecord = new HashMap<>();
        // 차량 번호, 요금 (차량 번호를 기준으로 오름차순)
        Map<String,Integer> fee = new TreeMap<>();
        
        for(String record : records){
            String[] r = record.split(" ");
            int time = getMinute(r[0]);
            String carNum = r[1];
            String io = r[2];
            
            if(io.equals("IN")){
                parkingRecord.put(carNum,time);
                
            }else if(io.equals("OUT")){
                int inTime = parkingRecord.get(carNum);
                //이전 입출력 기록이 있다면
                if(fee.containsKey(carNum)){
                    int beforeFee = fee.get(carNum);
                    fee.put(carNum, beforeFee + time - inTime);
                }else{
                    fee.put(carNum,time-inTime);
                }
                parkingRecord.remove(carNum);
            }
        }
        
        if(!parkingRecord.isEmpty()){
            for(String num : parkingRecord.keySet()){
                int beforeFee = fee.containsKey(num) ? fee.get(num) : 0;
                fee.put(num,beforeFee + getMinute("23:59") - parkingRecord.get(num));
            }
        }
        
        //요금 계산
        List<Integer> answer = new ArrayList<>();
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        for(int t : fee.values()){
            if(t <= defaultTime){
                answer.add(defaultFee);
            }else{
                answer.add(defaultFee + (int)Math.ceil((double)(t-defaultTime)/unitTime) * unitFee);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    public int getMinute(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}