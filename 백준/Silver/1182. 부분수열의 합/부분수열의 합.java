
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1182
 * 1. 아이디어
 * - 백트래킹으로 모든 조합의 합을 계산한다.
 * 2. 시간복잡도
 * - N ^ 20
 * 3. 자료구조
 * - 입력 수열을 저장할 배열
 */

public class Main {

    static int N,S;
    static int[] num;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] split = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = split[0];
        S = split[1];

        num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        backTracking(0,0);

        //공집합인 경우 --
        if (S == 0) result--;

        System.out.println(result);
    }

    static void backTracking(int depth,int sum) {

        //끝까지 탐색했을때
        if (depth == N) {
            //합이 s를 만족한다면
            if (sum == S) {
                result++;
            }
            return;
        }

        //현재 인덱스의 숫자를 포함하는 경우
        backTracking(depth+1, sum + num[depth]);
        //현재 인덱스의 숫자를 포함하지 않는 경우
        backTracking(depth+1, sum);

    }



}
