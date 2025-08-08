import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 아이디어
 * - 1. 0인 곳에서 랜덤으로 2군데에 벽을 설치한다.
 * - 2. bfs로 바이러스를 퍼트린다.
 * - 3. 0인 칸의 개수를 계산한다.
 * 2. 시간복잡도
 * - n^2
 * 3. 자료구조
 * - BFS를 사용하기 위한 큐
 * - 방문지를 검색하기 위한 visited 배열
 */

public class Main {
    static int N,M;
    static int[][] space;
    static boolean[][] visited;
    static int result = 0;
    static int[][] temp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = split[0];
        M = split[1];

        space = new int[N][M];
        //데이터를 입력 받는다.
        for (int i = 0; i < N; i++) {
            space[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        temp = new int[N][M];

        makeWall(0);

        System.out.println(result);

    }

    static void makeWall(int count) {
        if (count == 3) {
            for (int i = 0; i < N; i++) {
                temp[i] = space[i].clone();
            }
            visited = new boolean[N][M];
            findVirus();
            findSave();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (space[i][j] == 0) {
                    space[i][j] = 1;
                    makeWall(count + 1);
                    space[i][j] = 0;
                }
            }
        }
    }

    static void findSave() {

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        result = Math.max(cnt, result);

    }


    static void findVirus() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 2) {
                    bfs(i,j);
                }
            }
        }
    }

    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static void bfs(int x,int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        visited[x][y]= true;

        while (!q.isEmpty()) {
            //큐에서 하나의 원소를 뽑아 출력
            Node pN = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pN.x + dir[i][0];
                int ny = pN.y + dir[i][1];

                if (nx < N && nx >= 0 && ny < M && ny >= 0) {
                    if (!visited[nx][ny] && temp[nx][ny] == 0) {
                        temp[nx][ny]=2;
                        q.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}