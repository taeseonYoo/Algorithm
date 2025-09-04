
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        List<Node> list;
        List<List<Integer>> graph;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Node(x, y));
            }

            //그래프 초기화
            graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }

            //그래프 연결
            for (int i = 0; i < n + 2; i++) {
                for (int j = i; j < n + 2; j++) {
                    if (manhattan(list.get(i), list.get(j))) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            String result = bfs(graph, n) ? "happy" : "sad";
            System.out.println(result);

        }
    }

    static boolean bfs(List<List<Integer>> graph,int n) {
        Queue<Integer> q = new LinkedList<>();
        //집에서 출발한다.
        q.offer(0);

        boolean[] visited = new boolean[n + 2];
        visited[0] = true;

        while (!q.isEmpty()) {
            Integer poll = q.poll();

            if (poll == n + 1) {
                return true;
            }
            for (int i = 0; i < graph.get(poll).size(); i++) {
                Integer next = graph.get(poll).get(i);
                if (!visited[next]) {
                    q.add(next);
                    visited[next]=true;
                }
            }
        }
        return false;
    }

    static boolean manhattan(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y) <= 1000;
    }

    static class Node {
        int x;
        int y;
        Node next;

        public Node(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }


}
