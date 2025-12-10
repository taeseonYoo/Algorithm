import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 백준
 * 14889
 * 1. 시간 복잡도
 * O(n^2 * C(N,N/2))
 * n은 20이므로 가능하다.
 * 2. 공간 복잡도
 * 3. 아이디어
 * 모든 경우의 수를 조회한다. -> 백트래
 * 사람의 번호를 기준으로 백트래킹한다.
 */
class Main{
    static int[][]S;
    static int n;
    static boolean[] team;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        team = new boolean[n + 1];
        S = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(1, 0);

        System.out.println(result);
    }

    // idx는 팀을 구성해야하는 인덱스, depth는 팀을 구성한 사람 수
    static void backTracking(int idx, int depth) {
        if (depth == n / 2) {
            //계산한다.
            int sumA = 0;
            int sumB = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (team[i] && team[j]) {
                        sumA += S[i][j];
                        sumA += S[j][i];
                    } else if (!team[i] && !team[j]) {
                        sumB += S[i][j];
                        sumB += S[j][i];
                    }
                }
            }
            result = Math.min(Math.abs(sumA - sumB), result);
            return;
        }

        for (int i = idx; i <= n; i++) {
            team[i] = true;
            backTracking(i + 1, depth + 1);
            team[i] = false;
        }
    }

}