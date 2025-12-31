import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 * 1. 시간 복잡도
 * O(V+E)
 * 2. 공간 복잡도
 * 간선 저장 공간
 * 상태 저장 및 정답 저장 스택
 * 3. 아이디어
 * 위상 정렬
 */
class Main{
    static List<Integer>[] adj;
    static int[] state;
    static boolean hasCycle = false;
    static Stack<Integer> answer = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        state = new int[N+1];

        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");

            int size = Integer.parseInt(split[0]);

            if (size <= 1) continue;

            for (int j = 2; j <= size; j++) {
                int front_node = Integer.parseInt(split[j - 1]);
                int next_node = Integer.parseInt(split[j]);

                adj[front_node].add(next_node);
            }
        }
        //모든 노드에 대해서 dfs 연산 수행
        for (int i = 1; i <= N; i++) {
            if (state[i] == 0) {
                if (dfs(i)) {
                    hasCycle = true;
                    break;
                }
            }
        }

        if (hasCycle) {
            System.out.println(0);
            return;
        }

        while (!answer.isEmpty()) {
            System.out.println(answer.pop());
        }

    }

    static boolean dfs(int x) {
        //노드가 처리되는 중이다.
        state[x] = 1;

        for (int v : adj[x]) {
            if (state[v]==1) return true;
            if (state[v] == 0) {
                if (dfs(v)) return true;
            }
        }
        //노드의 처리가 끝났음/ 정답 스택에 넣는다.
        state[x]=2;
        answer.push(x);
        return false;
    }
}
