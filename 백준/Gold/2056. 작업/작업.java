import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] d;
    static int[] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        d = new int[N + 1];
        times = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            times[i] = time;
            //선행작업들을 처리한다.
            for (int j = 0; j < count; j++) {
                int job = Integer.parseInt(st.nextToken());
                graph.get(job).add(i);
                d[i]++;
            }
        }

        System.out.println(topological());
    }
    static int topological() {
        Queue<Integer> q = new LinkedList<>();

        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            result[i] = times[i];

            if (d[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                d[next]--;

                //각 작업을 완료하는데 드는 최소 시간을 계산한다.
                result[next] = Math.max(result[now] + times[next], result[next]);

                if (d[next] == 0) {
                    q.offer(next);
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, result[i]);
        }
        return answer;
    }
}