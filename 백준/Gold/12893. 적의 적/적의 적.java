import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 백준 1953
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main {
    static ArrayList<Integer>[] graph;
    static int[] friendship;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        friendship = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }

        Arrays.fill(friendship, -1);
        for (int i = 1; i <= n; i++) {
            if (friendship[i] == -1) {
                if (!dfs(i,0)) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);

    }

    static boolean dfs(int start, int c) {
        if (friendship[start]!=-1) return true;
        friendship[start] = c;

        for (int i = 0; i < graph[start].size(); i++) {
            int next = graph[start].get(i);
            if (friendship[next] == -1) {
                if (!dfs(next, 1 - c)) return false;
            } else if (friendship[next] == c) { //적대관계인 사람과 우호관계에 있다면
                return false;
            }
        }
        return true;
    }

}
