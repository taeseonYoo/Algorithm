import java.io.*;
import java.util.*;

/**
 * 1. 알고리즘
 * 위상 정렬 사용
 * 2. 자료구조
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<ArrayList<Integer>> graph = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] degree = new int[N + 1];

        //그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            //선행 차수를 의미한다.
            degree[B]++;
        }

        Queue<Node> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.add(new Node(i, 1));
            }
        }

        int[] result = new int[N + 1];

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            result[poll.getValue()] = poll.getTerm();

            for (int next : graph.get(poll.getValue())) {
                degree[next]--;
                if (degree[next] == 0) {
                    queue.add(new Node(next, poll.getTerm() + 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);


    }
    static class Node{
        int value;
        int term;

        public Node(int value, int term) {
            this.value = value;
            this.term = term;
        }
        public int getValue() {
            return value;
        }

        public int getTerm() {
            return term;
        }
    }
}
