import java.io.*;
import java.util.*;

/**
 * 1. 아이디어
 * - 1. 0인 곳에서 랜덤으로 3 장소에 벽을 설치한다.
 * - 2. bfs로 바이러스를 퍼트린다.
 * - 3. 0인 칸의 개수를 계산한다.
 * 2. 시간복잡도
 * - 벽 설치 -> 최악의 경우 약 O((NM)^3)
 * - BFS -> O(NM)
 * - 탐색 -> O(NM)
 * - 최종 O((NM)^3)으로 64*64*64 -> 약 26만이므로 가능하다.
 * 3. 자료구조
 * - BFS를 사용하기 위한 큐
 * - 방문지를 검색하기 위한 visited 배열
 * - 연구소의 데이터를 저장하기 위한 NxM 배열
 * - 연구소의 임시 데이터를 저장하기 위한 NxM 배열
 */

public class Main {
    static int N,M;
    //연구소 데이터
    static int[][] space;
    //임시 저장소
    static int[][] temp;
    static boolean[][] visited;
    //바이러스가 이동할 수 있는 방향
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int result = 0;
    //바이러스 위치 저장
    static List<Node> virus = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = split[0];
        M = split[1];

        space = new int[N][M];
        temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                if (map[j]==2) virus.add(new Node(i, j));
                space[i][j] = map[j];
            }
        }

        makeWall(0);

        System.out.println(result);
    }

    //백트래킹을 사용하여, 총 3개의 벽을 설치하는 방법을 고려한다.
    static void makeWall(int count) {
        //벽이 3개 설치가 완료된다.
        if (count == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    temp[i][j] = space[i][j];
                }
            }
            spreadVirus();
            findAnswer();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 연구소의 빈 칸에만 벽을 설치할 수 있다.
                if (space[i][j] == 0) {
                    space[i][j] = 1;
                    makeWall(count + 1);
                    space[i][j] = 0;
                }
            }
        }
    }

    //바이러스를 퍼트린다.
    static void spreadVirus() {
        for (Node node : virus) {
            visited = new boolean[N][M];
            bfs(node.x, node.y);
        }
    }
    static void findAnswer() {
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
    static void bfs(int x,int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        visited[x][y]= true;

        while (!q.isEmpty()) {
            //큐에서 하나의 원소를 뽑아 출력
            Node pN = q.poll();

            //바이러스가 이동할 수있는 상하좌우 고려
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