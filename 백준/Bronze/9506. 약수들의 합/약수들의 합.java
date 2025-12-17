import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * 백준 9506
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            int sum = 0;
            ArrayList<Integer> measures = new ArrayList<>();

            for (int i = 1; i <= n/2; i++) {
                if (n % i == 0) {
                    sum += i;
                    measures.add(i);
                }
            }

            if (sum == n) {
                String collect = measures.stream().map(String::valueOf)
                        .collect(Collectors.joining(" + "));
                System.out.println(n + " = " + collect);
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }

    }

}
