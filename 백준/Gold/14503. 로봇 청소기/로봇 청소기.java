import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int N,M;
    static int[][] map;
    static int r, c,d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        robot(r, c, d);
        System.out.println(answer);
    }


    static int[] mx = {-1, 0, 1, 0};
    static int[] my = {0, 1, 0, -1};
    static int answer = 0;

    static void robot(int x, int y, int dir) {

        //현재 칸이 청소되지 않은 경우, 청소한다.
        if (map[x][y] == 0) {
            map[x][y] = -1;
            answer++;
        }

        //현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우, 모두 1인 경우 true
        for (int i = 0; i < 4; i++) {
            dir = (dir+3)%4;
            int dx = x + mx[dir];
            int dy = y + my[dir];
            if (dx < N && dx >= 0 && dy < M && dy >= 0) {
                if (map[dx][dy] == 0) {
                    robot(dx,dy,dir);
                    return;
                }
            }
        }

        int dx = x - mx[dir];
        int dy = y - my[dir];

        if (dx < N && dx >= 0 && dy < M && dy >= 0 && map[dx][dy]!=1) {
            robot(dx,dy,dir);
        }

    }

}
