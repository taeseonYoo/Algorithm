import java.io.*;
import java.util.*;

/**
 * 백준 11399 - ATM
 * 1. 아이디어
 * 그리디 알고리즘
 * 정렬을 해서 낮은 순서의 값을 더한다.
 * 2. 시간복잡도
 * O(N) -> 정렬
 * 3. 자료구조
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] times = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);

        int answer = times[0];

        for (int i = 1; i < n; i++) {
            times[i] = times[i - 1] + times[i];
            answer += times[i];
        }

        System.out.println(answer);
    }
}