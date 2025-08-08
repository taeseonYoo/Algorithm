import java.io.*;
import java.util.*;

/**
 * 1. 아이디어
 * - BFS
 * 2. 시간복잡도
 * - O( N + M )
 * 3. 자료구조
 * - BFS를 위한 큐
 * - 방문을 확인하기 위한 visited 배열
 * - 네트워크를 저장하기 위한 배열
 */

public class Main {
    static int n,m;
    static int[][] network;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        network = new int[n+1][n+1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            network[split[0]][split[1]] = network[split[1]][split[0]] = 1;
        }

        bfs(1);

        System.out.println(result-1);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        visited[start]=true;

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            result++;

            for (int i = 1; i <= n; i++) {
                if (network[poll][i] == 1) {
                    if (!visited[i]) {
                        q.add(i);
                        visited[i]=true;
                    }
                }
            }
        }
    }



}