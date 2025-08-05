import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 배열 A의 누적합을 저장한다.
        List<Long> sumA = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }

        int m = Integer.parseInt(br.readLine());

        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 배열 B의 누적합을 저장한다.
        List<Long> sumB = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB);

        //포인터
        int ptA = 0;
        int ptB = sumB.size()-1;

        //정답, 부 배열 쌍의 개수
        long answer = 0;

        // 투 포인터를 사용해서 부분합을 구한다.
        while (ptA < sumA.size() && ptB >= 0) {
            long sum = sumA.get(ptA) + sumB.get(ptB);

            long aNum = sumA.get(ptA);
            long bNum = sumB.get(ptB);

            if (sum < T) {
                ptA++;
            } else if (sum > T) {
                ptB--;
            } else {
                long countA = 0;
                long countB = 0;
                while (ptA < sumA.size() && sumA.get(ptA) == aNum) {
                    countA++;
                    ptA++;
                }
                while (ptB >= 0 && sumB.get(ptB) == bNum) {
                    countB++;
                    ptB--;
                }
                answer += (countA * countB);
            }
        }

        System.out.println(answer);

    }

}