
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 N과 M(5) - 15654
 * 1. 아이디어
 * - 백트래킹
 * - 재귀함수에서 M개를 선택할 경우 print
 * 2. 시간복잡도
 * -  N!
 * 3. 자료구조
 * - 방문여부 체크
 * - 결과값 저장
 */

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    static int[] numbers;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = split[0];
        M = split[1];

        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //사전 순 출력을 위해, 정렬
        Arrays.sort(numbers);

        //방문여부
        visited = new boolean[N];
        result = new int[N];

        recur(0);
        System.out.println(sb);
    }

    //백트래킹
    static void recur(int num) {
        if (num == M) {
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[num] = numbers[i];
                recur(num+1);

                visited[i] = false;
            }
        }
    }

}
