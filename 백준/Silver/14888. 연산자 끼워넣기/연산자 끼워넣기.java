import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 백준
 * 14888
 * 1. 시간 복잡도
 * 11! / 3! 3! 3! 2!
 * 2. 공간 복잡도
 * 3. 아이디어
 * 연산자의 순서를 백트래킹을 통해 모든 경우의 수를 구한다.
 */
class Main{
    static int n;
    static int[] numbers;
    static int[] operatorCount;
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        numbers = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        operatorCount = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operatorCount[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(numbers[0], 1);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    static void backTracking(int result,int depth) {
        if (depth == n) {
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }

        for (int i = 0; i < operatorCount.length; i++) {
            if (operatorCount[i] > 0) {
                operatorCount[i]--;

                if (i == 0) { //덧셈
                    backTracking(result + numbers[depth], depth + 1);
                } else if (i == 1) {
                    backTracking(result - numbers[depth], depth + 1);
                } else if (i == 2) {
                    backTracking(result * numbers[depth], depth + 1);
                } else if (i == 3) {
                    backTracking(result / numbers[depth], depth + 1);
                }
                operatorCount[i]++;
            }
        }
    }

}