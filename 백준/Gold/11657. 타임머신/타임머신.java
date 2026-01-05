import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 백준 11657
 * 1. 시간 복잡도
 * O(NM) 모든 간선을 N-1번 탐색한다.
 * 2. 공간 복잡도
 * 간선 정보를 저장하는 동적 배열 M개
 * 거리 정보를 저장하는 배열 N+1개
 * 3. 아이디어
 */
class Main {
    static final Integer INF = Integer.MAX_VALUE;
    static int N,M;
    static ArrayList<Bus> paths;
    static long[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paths = new ArrayList<>();
        distance = new long[N + 1];
        //거리를 무한대로 초기화한다.
        Arrays.fill(distance, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken()); //시작도시
            int B = Integer.parseInt(st.nextToken()); //도착도시
            int C = Integer.parseInt(st.nextToken()); //걸리는 시간
            paths.add(new Bus(A, B, C));
        }

        //1번 도시에서 출발한다.
        distance[1] = 0;
        for (int i = 1; i <= N - 1; i++) {
            for (Bus bus : paths) {
                if (distance[bus.origin] != INF) {
                    distance[bus.destination] = Math.min(distance[bus.origin] + bus.time, distance[bus.destination]);
                }
            }
        }

        //N번째 탐색에서도 값이 갱신된다면 -> 음수 사이클이 존재한다.
        boolean hasNegativeCycle = false;
        for (Bus bus : paths) {
            if (distance[bus.origin]!=INF && distance[bus.destination] > distance[bus.origin] + bus.time) {
                hasNegativeCycle = true;
                break;
            }
        }
        if (hasNegativeCycle) {
            System.out.println(-1);
            return;
        }
        //결과 출력
        for (int i = 2; i <= N; i++) {
            if (distance[i] == INF) {
                System.out.println(-1);
            } else System.out.println(distance[i]);
        }

    }

}
class Bus{
    int origin;
    int destination;
    int time;

    public Bus(int origin, int destination, int time) {
        this.origin = origin;
        this.destination = destination;
        this.time = time;
    }
}
