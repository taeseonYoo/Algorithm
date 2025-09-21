import java.io.*;
import java.util.*;



public class Main {

    static int N;
    static int[][] plate;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        plate = new int[N][N];

        backTracking(0);

        System.out.println(result);

    }

    public static void backTracking(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isPossible(row, col)) {
                plate[row][col] = 1;
                backTracking(row + 1);
                plate[row][col] = 0;
            }
        }
    }

    static boolean isPossible(int row, int col) {
        for (int i = 0; i < row; i++) {
            //같은 열에 퀸이 있는 지 확인한다.
            if (plate[i][col] == 1) {
                return false;
            }
            //왼쪽 위 대각선에 퀸이 있는 지 확인
            if (col - row + i >= 0 && plate[i][col - row + i] == 1) {
                return false;
            }
            if (col + row - i < N && plate[i][col + (row - i)] == 1) {
                return false;
            }
        }
        return true;
    }
}
