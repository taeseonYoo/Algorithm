import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] split = line.split(" ");

        int K = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);

        //랜선을 저장하기 위한 배열
        int[] lan = new int[K];

        int max = 0;
        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,lan[i]);
        }

        long start = 1;
        long end = max;

        long answer = 0;
        //이진 탐색으로 해를 찾는다.
        while (start <= end) {

            long mid = (start + end) / 2;
            //만들 수 있는 랜선의 개수
            int count = 0;

            for (int i = 0; i < K; i++) {
                count += (lan[i]/mid);
            }
            if (count < N) {
                end = mid - 1;
            } else{
                answer = Math.max(answer, mid);
                start = mid + 1;
            }
        }

        System.out.println(answer);

    }

}
