import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int zeroCount = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < 0) negative.add(num);
            else if (num > 0) positive.add(num);
            else zeroCount++;
        }

        while (positive.size() > 1) {
            int a = positive.remove();
            int b = positive.remove();

            if (a == 1 || b == 1){
                answer+= a;
                answer+= b;
            }
            else answer += (a * b);
        }
        if (!positive.isEmpty()) {
            answer += positive.poll();
        }

        while (negative.size() > 1) {
            int a = negative.remove();
            int b = negative.remove();
            answer += (a * b);
        }
        if (!negative.isEmpty()) {
            if (zeroCount == 0) {
                answer += negative.poll();
            }
        }

        System.out.println(answer);
    }
}