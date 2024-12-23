import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


class Node implements Comparable<Node>{
    private int distance;
    private int index;

    public Node(int distance,int index){
        this.distance = distance;
        this.index = index;
    };

    public int getIndex(){
        return index;
    }
    public int getDistance(){
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    public static final int INF = (int) 1e9;
    public static int[] d = new int[300001];
    public static int n,m,k,x;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split(" ");

        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        k = Integer.parseInt(line[2]);
        x = Integer.parseInt(line[3]);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            String[] info = bf.readLine().split(" ");
            graph.get(Integer.parseInt(info[0])).add(new Node(1, Integer.parseInt(info[1])));
        }


        Arrays.fill(d,INF);

        djikstra(x);

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                answer.add(i);
            }
        }

        Collections.sort(answer);

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }

    }

    private static void djikstra(int x) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        d[x]=0;
        pq.offer(new Node(0,x));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int dist = node.getDistance();
            int now = node.getIndex();

            if (d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(cost,graph.get(now).get(i).getIndex()));
                }
            }
        }

    }

}
