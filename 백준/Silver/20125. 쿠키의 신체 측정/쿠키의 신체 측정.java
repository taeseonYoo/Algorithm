import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[][] ch;
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

        //심장의 위치 기록
        int hx = 0;
        int hy = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                boolean isHeart = true;
                if (ch[i][j] == '*') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x > n || x < 1 || y > n || y < 1 || ch[x][y]!='*') {
                            isHeart = false;
                        }
                    }
                } else isHeart = false;

                if (isHeart) {
                    hx = i;
                    hy = j;
                    break;
                }
            }
        }

        int[] result = new int[5];


        int count = 1;

        result[0] = dfs(hx, hy - 1, 0, -1, count);
        result[1] = dfs(hx, hy + 1, 0, 1, count);
        result[2] = dfs(hx + 1, hy, 1, 0, count);
        result[3] = dfs(hx + result[2] + 1, hy - 1, 1, 0, count);
        result[4] = dfs(hx + result[2] + 1, hy + 1, 1, 0, count);



        System.out.println(hx+" "+hy);

        for (int i = 0; i < 5; i++) {
            System.out.print(result[i]+" ");
        }

    }


    public static int dfs(int sx, int sy, int tx, int ty, int count){

        int x = sx + tx;
        int y = sy + ty;

        if (x < 1 || x > n || y < 1 || y > n || ch[x][y] != '*') {
            return count; //종료되는 포인트를 찾으면 그 때 count 반환
        }

        return dfs(x, y, tx, ty, count + 1);
    }

}

