import java.io.*;
import java.util.*;

/**
 * 1. 아이디어
 * 2. 시간복잡도
 * 3. 자료구조
 */

public class Main {
    static int N,M,V;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = split[0];
        M = split[1];
        V = split[2];

        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            int[] nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(nodes[0]).add(nodes[1]);
            list.get(nodes[1]).add(nodes[0]);
        }
        for (List<Integer> integers : list) {
            integers.sort(Comparator.naturalOrder());
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }

    static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < list.get(start).size(); i++) {
            Integer x = list.get(start).get(i);
            if (!visited[x]) dfs(x);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        visited[start]=true;

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            System.out.print(poll+" ");

            for (int i = 0; i < list.get(poll).size(); i++) {
                Integer next = list.get(poll).get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next]=true;
                }
            }
        }
    }

}