import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 * 연결 리스트?
 */
class Main{

    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //도시의 수
        int M = Integer.parseInt(br.readLine()); //여행 계획에 속한 도시들의 수
        visited = new boolean[N + 1];

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken())==1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }

        String line = br.readLine();
        String[] split = line.split(" ");
        dfs(Integer.parseInt(split[0]));
        boolean isPossible = true;

        for (int i = 0; i < split.length; i++) {
            int city = Integer.parseInt(split[i]);
            if (!visited[city]) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
    public static void dfs(int start) {
        visited[start] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 0; i < list.get(poll).size(); i++) {
                Integer a = list.get(poll).get(i);
                if (!visited[a]) {
                    q.add(a);
                    visited[a] = true;
                }
            }
        }
    }

}