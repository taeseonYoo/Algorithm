import java.util.*;
class Solution {
    String[][] tickets;
    List<String> answer;
    boolean[] visited;
    public List<String> solution(String[][] tmp) {
        tickets = tmp;
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        visited = new boolean[tickets.length];
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs("ICN",path,0);
        
        return answer;
    }
    
    boolean find = false;
    
    public void dfs(String from,List<String> path,int depth){
        if(find) return;
        //정답이라면
        if(depth == tickets.length){
            answer = new ArrayList<>(path);
            find = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(from)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                
                dfs(tickets[i][1], path, depth + 1);
                
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }

    }
}