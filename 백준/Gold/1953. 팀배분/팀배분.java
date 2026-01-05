import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 백준 1953
 * 1. 시간 복잡도
 * 그래프 탐색 O(E+V)
 * 2. 공간 복잡도
 * 인접행렬 N+1 * N+1
 * 3. 아이디어
 * 이분 그래프를 활용하여 탐색한다.
 */
class Main{
    static int[][] graph;
    static int[] color;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        color = new int[n + 1];
        Arrays.fill(color, 2); //방문한 적 없는 노드는 2

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int hater = Integer.parseInt(st.nextToken());
                graph[i][hater] = 1; //싫어하는 사람을 표기한다.
            }
        }
        //모든 노드를 탐색한다.
        for (int i = 1; i <= n; i++) {
            if (color[i] == 2) {
                dfs(i, 0);
            }
        }

        System.out.println(collectResults());
    }

    static void dfs(int start,int c) {
        if (color[start]!=2) return;
        color[start] = c;

        for (int i = 1; i <= n; i++) {
            if (graph[start][i] == 1) {
                dfs(i, 1 - c);
            }
        }
    }

    static String collectResults() {
        StringBuilder answer = new StringBuilder();

        ArrayList<Integer> blueTeam = new ArrayList<>();
        ArrayList<Integer> whiteTeam = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) blueTeam.add(i);
            else whiteTeam.add(i);
        }

        answer.append(blueTeam.size()).append("\n");
        for (int value : blueTeam) {
            answer.append(value).append(" ");
        }
        answer.append("\n");

        answer.append(whiteTeam.size()).append("\n");
        for (int value : whiteTeam) {
            answer.append(value).append(" ");
        }
        return answer.toString();
    }
}
