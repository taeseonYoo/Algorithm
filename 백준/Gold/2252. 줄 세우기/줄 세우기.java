import java.io.*;
import java.util.*;



public class Main {

    static int N,M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        //차수 배열
        int[] degree = new int[N + 1];

        // 그래프 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            //자신보다 작은 키를 가진 학생의 수가 몇 명인지 계산
            degree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int poll = q.poll();
            sb.append(poll).append(" ");

            for (int next : graph.get(poll)) {
                degree[next]--;

                if (degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        System.out.println(sb);


    }



}
