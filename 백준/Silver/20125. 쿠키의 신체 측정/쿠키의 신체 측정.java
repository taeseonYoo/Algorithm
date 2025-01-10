import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[][] ch;
    static boolean[][]visited;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        ch = new char[n + 1][n + 1];

        //입력 받기
        for (int i = 1; i < n+1; i++) {
            String line = bf.readLine();
            for (int j = 0; j < n; j++) {
                ch[i][j + 1] = line.charAt(j);
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int hx = 0;
        int hy = 0;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n + 1; j++) {
                boolean flag = false;
                if (ch[i][j] == '*') {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx <= n && nx >= 1 && ny <= n && ny >= 1) {
                            if (ch[nx][ny] != '*') {
                                flag = false;
                                break;
                            } else {
                                flag = true;
                            }
                        }
                    }
                    if (flag) {
                        hx = i;
                        hy = j;
                        break;
                    }
                }
            }
        }
        int[] s = new int[5];

        visited = new boolean[n + 1][n + 1];

        int count = 1;

        s[0] = dfs(hx, hy-1, 0, -1, count);
        s[1] = dfs(hx, hy + 1, 0, 1, count);
        s[2] = dfs(hx + 1, hy, 1, 0, count);
        s[3] = dfs(hx + s[2] + 1, hy - 1, 1, 0, count);
        s[4] = dfs(hx + s[2] + 1, hy + 1, 1, 0, count);

        System.out.println(hx+" "+hy);
        for (int i = 0; i < 5; i++) {
            System.out.print(s[i]+" ");
        }
    }


    public static int dfs(int sx, int sy, int tx, int ty, int count){

        int x = sx + tx;
        int y = sy + ty;

        // 범위를 벗어나거나 조건에 맞지 않으면 현재 count 반환
        if (x < 1 || x > n || y < 1 || y > n || ch[x][y] != '*' || visited[x][y]) {
            return count;
        }

        visited[x][y] = true; // 방문 처리

        // 재귀 호출 결과를 받아서 count를 갱신
        return dfs(x, y, tx, ty, count + 1);

    }

}

