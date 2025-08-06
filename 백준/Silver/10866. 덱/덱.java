
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        while (n-- > 0) {
            String line = br.readLine();
            String[] split = line.split(" ");

            String command = split[0];

            if (command.equals("push_front")) {
                deque.addFirst(Integer.parseInt(split[1]));
            } else if (command.equals("push_back")) {
                deque.addLast(Integer.parseInt(split[1]));
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollFirst());
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollLast());
            } else if (command.equals("size")) {
                System.out.println(deque.size());
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            } else if (command.equals("front")) {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.getFirst());
            }else {
                if (deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.getLast());
            }
        }

    }

}
