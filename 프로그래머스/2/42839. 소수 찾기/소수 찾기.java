import java.util.*;

class Solution {
    public Boolean[] atc = new Boolean[10000001];
    public Map<Integer,Integer> m = new HashMap<>();
    public int answer = 0;
    
    public int solution(String numbers) {
        
        Arrays.fill(atc,true);
        vali();
        
        String[] arr = numbers.split("");
        String[] output = new String[arr.length];
        boolean[] visited = new boolean[arr.length];
        
        
        for(int i=0;i<arr.length;i++){
            permutation(arr,output,visited,0,i+1);
        }
        
        for(int num : m.keySet()){
            if(atc[num] && num >1){

                answer++;
            }
        }
        
        return answer;
    }
    public void permutation(String[] arr, String[] output,boolean[] visited,int depth,int r){
        
        if(depth == r){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<r;i++){
                sb.append(output[i]);
            }
            int target = Integer.parseInt(sb.toString());
            
            if(atc[target]==true){
                m.put(target,0);
            }
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                output[depth]=arr[i];
                permutation(arr, output, visited, depth + 1, r);
                visited[i]=false;
            }
            
        }
    }
    
    public void vali(){
        
        for(int i=2;i<=Math.sqrt(atc.length);i++){
            if(atc[i]==true){
                int j=2;
                while(i*j < atc.length){
                    atc[i*j]=false;
                    j++;
                }
            }
            
        }
    }
}