import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        Integer[] num = new Integer[arr.length];
        
        for(int i=0;i<arr.length;i++){
            num[i] = Integer.parseInt(arr[i]);
        }
        
        
        Arrays.sort(num);
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.valueOf(num[0]));
        sb.append(" ");
        sb.append(String.valueOf(num[num.length-1]));
        
        return sb.toString();
    }
}