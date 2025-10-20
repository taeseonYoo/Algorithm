import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        
        List<ArrayList<Integer>> warehouse = new ArrayList<>();
        
        for(int i=0;i<=w;i++){
            warehouse.add(new ArrayList<>());
        }
    
        
        int box = 1;
        boolean leftToRight = true;

        // 상자 쌓기 (지그재그)
        while (box <= n) {
            if (leftToRight) {
                for (int i = 1; i <= w && box <= n; i++) {
                    warehouse.get(i).add(box++);
                }
            } else {
                for (int i = w; i >= 1 && box <= n; i--) {
                    warehouse.get(i).add(box++);
                }
            }
            leftToRight = !leftToRight;
        }
        
        for(int i=1;i<=w;i++){
            List<Integer> column = warehouse.get(i);
            int index = column.indexOf(num);
            if (index != -1) {
                return column.size() - index;
            }
        }
        
        
        return answer;
    }
}