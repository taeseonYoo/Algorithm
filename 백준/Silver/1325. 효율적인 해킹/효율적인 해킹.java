import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    static int[] result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;

            graph.get(A).add(B);
        }

        result = new int[n];

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            bfs(i);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (max == result[i]) {
                sb.append(i + 1).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void bfs(int start) {

        Queue<Integer> q = new LinkedList<Integer>();
        visited[start] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int a : graph.get(now)) {
                if(!visited[a]) {
                    visited[a] =true;
                    result[a]++;
                    q.add(a);
                }
            }
        }
    }

}