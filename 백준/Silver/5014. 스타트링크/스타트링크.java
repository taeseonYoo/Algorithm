
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 5014
 * 1. 아이디어
 * - 버튼을 적어도 몇 번 눌러야 하는지 -> 너비 우선 탐색
 *
 * 2. 시간복잡도
 * - 너비 우선 탐색은 O( F )
 *
 * 3. 자료구조
 * - 너비 우선 탐색을 위한 큐
 * - 방문 기록을 위한 visited 배열
 * 
 * 4. 입력 데이터
 * F : 건물 층수
 * S : 현재 위치
 * G : 타켓 위치
 * U : 위로 몇 칸
 * D : 아래로 몇 칸
 */

public class Main {

    static int F,S,G,U,D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int[] split = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        F = split[0];
        S = split[1];
        G = split[2];
        U = split[3];
        D = split[4];

        visited = new boolean[F + 1];

        int result = bfs();

        //Edge case
        if (S == G) System.out.println(0);
        else System.out.println(result == -1 ? "use the stairs" : result);

    }

    static int bfs(){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(S, 0));
        visited[S]=true;

        while (!q.isEmpty()) {
            //현재 층
            Node poll = q.poll();

            if (poll.getFloor() == G) {
                return poll.getCount();
            }

            //내려갈 수 있다면
            int down = poll.getFloor() - D;
            if (down >= 1 && !visited[down]) {
                visited[down] = true;
                q.add(new Node(down, poll.getCount() + 1));
            }
            int up = poll.getFloor() + U;
            if(up <= F && !visited[up]){
                visited[up] = true;
                q.add(new Node(up, poll.getCount() + 1));
            }
        }

        return -1;
    }

    static class Node{
        int floor;
        int count;
        public Node(int floor,int count){
            this.floor = floor;
            this.count = count;
        }

        public int getFloor() {
            return floor;
        }

        public int getCount() {
            return count;
        }
    }

}
