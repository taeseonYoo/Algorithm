import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        
        Arrays.sort(people);

        int start = 0;
        int end = people.length-1;
        
        while(start<=end){
            
            if(people[end]+people[start] <=limit){
                start++;
                end--;
            }else{
                end--;
            }
            answer++;
        }
        

        return answer;
    }
}