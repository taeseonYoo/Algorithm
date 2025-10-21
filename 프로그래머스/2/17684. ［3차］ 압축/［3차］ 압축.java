import java.util.*;
class Solution {
    public int[] solution(String msg) {
        
        List<Integer> list = new ArrayList<>();
        
        HashMap<String,Integer> mp = new HashMap<>();
        //사전 초기화
        for(int i=0;i<26;i++){
            char alphabet = (char)('A' + i);
            mp.put(String.valueOf(alphabet),i+1);
        }
        
        int lastIndex = 27;
        int index = 0;
        
        while(index < msg.length()){
            String w = String.valueOf(msg.charAt(index));
            int j = index + 1;
            
            //현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
            while (j <= msg.length()) {
                String next = msg.substring(index, j);
                if (!mp.containsKey(next)) break;
                w = next;
                j++;
            }
            //사전의 색인 번호를 출력한다.
            list.add(mp.get(w));
            //사전에 등록한다.
            if (j <= msg.length()) {
                String newWord = msg.substring(index, j);
                mp.put(newWord, lastIndex++);
            }
            //입력에서 w를 제거한다.
            index += w.length();

        }
        int[] answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}