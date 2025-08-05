import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        int N = Integer.parseInt(br.readLine());

        String[] split = br.readLine().split(" ");

        int[] numbers = new int[split.length];
        
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }

        // 포인터를 사용해야 하므로, 오름차순으로 정렬
        Arrays.sort(numbers);


        for (int i = 0; i < N; i++) {
            //검사를 진행하는 숫자
            int targetNumber = numbers[i];

            int start = 0, end = N-1;
            while (start<end) {
                if (start == i) {
                    start++;
                    continue;
                }
                if (end == i) {
                    end--;
                    continue;
                }
                //왼쪽 포인터
                int left = numbers[start];
                //오른쪽 포인터
                int right = numbers[end];

                // 합이 타겟넘버보다 작다면 start를 증가시켜
                if (left + right < targetNumber) {
                    start++;
                } else if (left + right > targetNumber) {
                    end--;
                } else {
                    result++;
                    break;
                }
            }

        }


        System.out.println(result);
    }

}