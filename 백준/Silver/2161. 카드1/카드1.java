import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] agrs) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (true) {

            if (q.size() == 1) {
                sb.append(q.poll()).append(" ");
                break;
            }
            int num = q.poll();
            sb.append(num).append(" ");
            q.add(q.poll());
        }



        System.out.println(sb);

    }
}
