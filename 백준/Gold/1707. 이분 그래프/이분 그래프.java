import java.io.*;
import java.util.*;

/**
 * 1. 알고리즘
 * DFS
 * 시간 복잡도는 O(V+E)
 * 약 (5 * 22)만
 * 2. 자료구조
 * 색상을 기록하기 위한 color 배열
 * 노드 정보를 기록하기 위한 graph 이중 리스트
 */

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    //color 배열의 색상은 1과 -1로 표현한다. 0은 방문하지 않은 노드
    static int[]color;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            isBipartite = true;
            color = new int[V + 1];

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                graph.get(A).add(B);
                graph.get(B).add(A);
            }

            for (int i = 1; i <= V; i++) {
                if (!isBipartite) break;
                if (color[i]==0) {
                    dfs(i,1);
                }
            }

            System.out.println(!isBipartite ? "NO" : "YES");
        }
    }

    static void dfs(int start, int c) {
        if (!isBipartite) {
            return;
        }

        //해당 정점의 색을 칠한다.
        color[start] = c;

        for (int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);
            //미방문 노드
            if (color[next] == 0) {
                dfs(next, -c);
            } else if (color[next] == c) {
                isBipartite = false;
                return;
            }
        }
    }
}
