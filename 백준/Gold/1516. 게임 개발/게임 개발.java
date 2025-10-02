import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] degree = new int[N+1];
        int[] times = new int[N+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) break;
                graph.get(num).add(i);
                degree[i]++;
            }
        }

        int[] result = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();


        for (int i = 1; i <= N; i++) {
            if (degree[i]==0) {
                q.offer(i);
                result[i] = times[i];
            }
        }

        while (!q.isEmpty()) {
            int poll = q.poll();

            for (int i = 0; i < graph.get(poll).size(); i++) {
                int a = graph.get(poll).get(i);

                result[a] = Math.max(result[a], result[poll] + times[a]);
                if (--degree[a]==0) q.add(a);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);


    }
}