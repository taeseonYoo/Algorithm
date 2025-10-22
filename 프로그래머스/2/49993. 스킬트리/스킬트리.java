class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i=0;i<skill_trees.length;i++){
            
            String skill_tree = skill_trees[i];
            
            int[] tree = new int[skill.length()];
            
            int preSkill = -1;
            
            for(int j=0;j<skill.length();j++){
                char ch = skill.charAt(j);
                
                tree[j] = skill_tree.indexOf(ch);
            }
            //값을 검증한다.
            boolean isPossible = true;
            for(int k=1;k<tree.length;k++){
                int before = tree[k-1];
                int after = tree[k];
                
                if(before > after && after!= -1){
                    isPossible = false;
                    break;
                }else if(before < after && before == -1){
                    isPossible = false;
                    break;
                }
            }
            
            if(isPossible) answer++;
        }
        return answer;
    }
}