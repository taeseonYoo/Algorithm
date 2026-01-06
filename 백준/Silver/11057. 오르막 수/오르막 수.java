import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * 백준
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] answer = new int[N][10];

        Arrays.fill(answer[0], 1);

        int before = 10;

        for (int i = 1; i < N; i++) {
            int next = 0;
            for (int j = 0; j < 10; j++) {
                answer[i][j] = before % 10_007;
                next = (next + answer[i][j]) % 10_007;
                before = (before - answer[i - 1][j] + 10_007) % 10_007;
            }
            before = next;
        }

        System.out.println(before % 10_007);
    }
}

