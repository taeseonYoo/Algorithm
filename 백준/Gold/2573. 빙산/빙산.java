import java.io.*;
import java.util.*;

/**
 * 백준 2573 - 빙산
 * 1. 아이디어
 * 빙산의 덩어리를 찾기 위해서 BFS로 덩어리를 찾는다.
 * 2. 시간복잡도
 *
 * 3. 자료구조
 * 방문 배열
 */

public class Main {
    static int N,M;
    static int[][] iceberg;
    static int answer = 0;
    static boolean[][] visited;
    static boolean[][] melted;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceberg = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 500;

        while (count > 0) {

            answer = 0;
            visited = new boolean[N][M];

            //빙산의 덩어리 개수 세기
            for (int i = 1; i < N-1; i++) {
                for (int j = 1; j < M-1; j++) {
                    if (!visited[i][j] && iceberg[i][j]>0){
                        bfs(i, j);
                    }
                }
            }

            if(answer > 1 || answer == 0) break;

            //얼음 녹이기
            melted = new boolean[N][M];
            for (int i = 1; i < N-1; i++) {
                for (int j = 1; j < M-1; j++) {
                    if (iceberg[i][j]!=0){
                        int water = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if (nx >= 0 && ny >= 0 && nx < N && ny < M && iceberg[nx][ny]==0 && !melted[nx][ny]){
                                water++;
                            }
                        }
                        iceberg[i][j] = Math.max(0, iceberg[i][j] - water);
                        melted[i][j] = true;
                    }
                }
            }

            count--;
        }

        System.out.println(answer <= 1  ? 0 : 500-count);

    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && iceberg[nx][ny]>0) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        // 빙산의 덩어리는 마다 bfs를 돈다.
        answer++;
    }
}