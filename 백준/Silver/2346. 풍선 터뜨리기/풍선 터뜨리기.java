import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;


/**
 * 1. 시간 복잡도
 * 2. 공간 복잡도
 * 3. 아이디어
 */
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        Deque<Balloon> dq = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            dq.addLast(new Balloon(i,Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();

        Balloon current = dq.pollFirst();
        sb.append(current.id).append(" ");
        int next = current.value;

        while (!dq.isEmpty()) {

            if (next < 0) { //왼쪽으로 이동한다.
                for (int i = 0; i < Math.abs(next); i++) {
                    dq.addFirst(dq.pollLast());
                }
                current = dq.pollFirst();
            } else if (next > 0) { //오른쪽으로 이동한다.
                for (int i = 0; i < next-1; i++) {
                    dq.addLast(dq.pollFirst());
                }
                current = dq.pollFirst();
            }
            sb.append(current.id).append(" ");
            next = current.value;
        }

        System.out.println(sb);
    }
    static class Balloon{
        int id;
        int value;

        public Balloon(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }
}
