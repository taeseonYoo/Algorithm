
import java.io.*;
import java.util.*;

class Node {
    private int index;
    private int distinct;

    public Node(int index, int distinct) {
        this.index = index;
        this.distinct = distinct;
    }

    public int getIndex() {
        return index;
    }

    public int getDistinct() {
        return distinct;
    }
}

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static int n,k;
    static int[] d = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        k = Integer.parseInt(split[1]);

        if (n >= k){
            System.out.println(n - k);
            return;
        }
        
        Arrays.fill(d, INF);

        dijkstra();
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.getDistinct() - b.getDistinct()
        );
        pq.add(new Node(n, 0));
        d[n] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistinct();

            if (d[now] < dist) continue;

            if (now == k){
                break;
            }
            if (now - 1 >= 0) {
                if (d[now] + 1 < d[now - 1]) {
                    d[now - 1] = d[now] + 1;
                    pq.add(new Node(now - 1, d[now - 1]));
                }
            }
            if (now + 1 <= 100000) {
                if (d[now] + 1 < d[now + 1]) {
                    d[now + 1] = d[now] + 1;
                    pq.add(new Node(now + 1, d[now + 1]));
                }
            }
            if (now * 2 <= 100000) {
                // 갱신될 때만 큐에 추가
                if (d[now] < d[now * 2]) {
                    d[now * 2] = d[now];
                    pq.add(new Node(now * 2, d[now * 2]));
                }
            }
        }
        System.out.println(d[k]);
    }
}