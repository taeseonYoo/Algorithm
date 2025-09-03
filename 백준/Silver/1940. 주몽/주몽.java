
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 5014
 * 1. 아이디어
 * - 두 개의 재료로 만들기 때문에 누적합을 사용할 수 있다.
 * - 값을 정렬해서 양쪽 포인터를 두고 차례로 검증한다.
 * 2. 시간복잡도
*/

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] split = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(split);

        int startIdx = 0;
        int endIdx = N-1;

        int result = 0;
        while (startIdx < endIdx) {

            int sum = split[startIdx] + split[endIdx];
            
            if (sum == M) {
                result++;
                startIdx++;
                endIdx--;
            }
            else if (sum < M) startIdx++;
            else endIdx--;
        }

        System.out.println(result);

    }

}
