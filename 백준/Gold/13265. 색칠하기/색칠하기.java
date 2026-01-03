import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 백준 13265
 * 1. 시간 복잡도
 * O(N + M) -> 모든 노드를 한 번씩 방문한다.
 * 2. 공간 복잡도
 * 인접 리스트 -> O(N + M)
 * 3. 아이디어
 * 이분 그래프를 활용하여 판단한다.
 */
class Main{
    static ArrayList<Integer>[] graph;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder answer = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            //그래프 초기화
            graph = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            //간선 정보 입력
            color = new int[n + 1];
            Arrays.fill(color, 2); // 0은 레드 1은 블랙 2는 방문하지 않은 노드

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x].add(y);
                graph[y].add(x);
            }

            boolean isPossible = true;
            for (int i = 1; i <= n; i++) {
                if (color[i] == 2) {
                    if (!dfs(i, 0)) {
                        isPossible = false;
                        break;
                    }
                }
            }
            if (isPossible) {
                answer.append("possible").append("\n");
            } else {
                answer.append("impossible").append("\n");
            }
        }
        System.out.println(answer);

    }
    static boolean dfs(int start,int c) {
        if (color[start] != 2) {
            return true;
        }
        color[start] = c;

        for (int next : graph[start]) {
            if (color[next]==2){ //방문하지 않은 노드는 방문
                if (!dfs(next, 1 - c)) return false;
            } else if (color[next] == c) { //현재 노드와 이웃한 노드의 색상이 동일하다면 불가능
                return false;
            }
        }
        return true;
    }

}
