import java.io.*;
import java.util.*;


/**
 * N과 M (1)
 * 백트래킹
 *
 * 방문 요소를 저장할 배열 필요
 *
 */

public class Main {

    static int N,M;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M+1];
        visited = new boolean[N + 1];

        backTracking(0);

        System.out.println(sb.toString());
    }

    static public void backTracking(int depth) {
        //M개의 숫자를 만족하면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=N;i++){
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
