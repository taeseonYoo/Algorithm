import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        Queue<Integer> q = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            //가장 맨 위의 숫자를 버린다.
            q.remove();

            //큐의 맨 위에 있는 카드를 제일 아래로 옮긴다.
            Integer poll = q.poll();
            q.add(poll);
        }
        System.out.println(q.poll());


    }


}
