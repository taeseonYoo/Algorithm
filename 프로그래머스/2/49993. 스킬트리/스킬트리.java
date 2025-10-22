import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skill_tree : skill_trees){
            
            int skillIndex = 0;
            boolean isPossible = true;
            
            for(char currentSkill : skill_tree.toCharArray()){
                
                int requiredIndex = skill.indexOf(currentSkill);
                
                if(requiredIndex == -1){
                    continue;
                }
                
                if(requiredIndex != skillIndex){
                    isPossible = false;
                    break;
                }
                skillIndex++;
            }
            
            if(isPossible) answer++;
        }
        return answer;
    }
}