import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < T; i++) {
            pq.add(Long.parseLong(bf.readLine()));
        }

        long result = 0;
        

        while(!pq.isEmpty()){
            if (pq.size() >= 2) {
                long num1 = pq.poll();
                long num2 = pq.poll();
                result += num1+num2;
                pq.add(num1 + num2);
            } else {
                break;
            }
        }

        System.out.println(result);

    }
}

