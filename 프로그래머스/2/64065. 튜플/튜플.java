import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        Set<String> set = new HashSet<>();
        
        String[] sa = s.replace("{", " ").replaceAll("}", " ").trim().split(" , ");
        
        Arrays.sort(sa, (a, b)->{return a.length() - b.length();});
        
        int[] answer = new int[sa.length];
        
        int idx = 0;
        
        for(String s1 : sa) {
            for(String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}