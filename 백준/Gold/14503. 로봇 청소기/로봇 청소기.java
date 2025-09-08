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

    static void robot(int x, int y,int dir) {

        if (map[x][y]==0){
            map[x][y] = 2;
            answer++;
        }

        //주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
        for (int i = 0; i < 4; i++) {
            dir = (dir+3)%4;
            int nx = x + mx[dir];
            int ny = y + my[dir];

            if (nx < N && ny < M && nx >= 0 && ny >= 0) {
                if (map[nx][ny] == 0) {
                    robot(nx, ny, dir);
                    return;
                }
            }
        }

        //주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        int nx = x - mx[dir];
        int ny = y - my[dir];
        if (nx < N && ny < M && nx >= 0 && ny >= 0 && map[nx][ny] != 1) {
            robot(nx, ny, dir);
        }
    }

}
