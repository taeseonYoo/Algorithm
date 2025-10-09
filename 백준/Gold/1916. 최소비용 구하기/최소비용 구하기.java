import com.sun.jdi.IntegerType;

import java.io.*;
import java.util.*;

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class Main {
    public static final int INF = Integer.MAX_VALUE;
    public static int n,m, start, target;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static int[] d = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]);
            int e = Integer.parseInt(split[1]);
            int v = Integer.parseInt(split[2]);

            graph.get(s).add(new Node(e, v));
        }
        Arrays.fill(d,INF);

        String[] split = br.readLine().split(" ");
        start = Integer.parseInt(split[0]);
        target = Integer.parseInt(split[1]);

        dijkstra();

        System.out.println(d[target]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.getDistance() - b.getDistance()
        );
        //시작 노드로 가는 경우는 0
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nodeIndex = node.getIndex();
            int distance = node.getDistance();

            if (d[nodeIndex] < distance) continue;

            for (int i = 0; i < graph.get(nodeIndex).size(); i++) {
                int cost = d[nodeIndex] + graph.get(nodeIndex).get(i).getDistance();

                if (cost < d[graph.get(nodeIndex).get(i).getIndex()]) {
                    d[graph.get(nodeIndex).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(nodeIndex).get(i).getIndex(), cost));
                }
            }
        }

    }
}