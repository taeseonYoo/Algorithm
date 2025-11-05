import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                int X = Integer.parseInt(st.nextToken());
                dq.addFirst(X);
            } else if (command == 2) {
                int X = Integer.parseInt(st.nextToken());
                dq.addLast(X);
            } else if (command == 3) {
                if (!dq.isEmpty()) {
                    System.out.println(dq.pollFirst());
                }else{
                    System.out.println(-1);
                }
            } else if (command == 4) {
                if (!dq.isEmpty()) {
                    System.out.println(dq.pollLast());
                }else{
                    System.out.println(-1);
                }
            } else if (command == 5) {
                System.out.println(dq.size());
            } else if (command == 6) {
                if (dq.isEmpty()) {
                    System.out.println(1);
                }
                else System.out.println(0);
            } else if (command == 7) {
                if (!dq.isEmpty()) {
                    System.out.println(dq.getFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (command == 8) {
                if (!dq.isEmpty()) {
                    System.out.println(dq.getLast());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}