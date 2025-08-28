
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

/**
 * 백준 5014
 * 1. 아이디어
 * - 적어도 몇 번 눌러야 하는지
 * - > 너비 우선 탐색
 * 2. 시간복잡도
 * - 너비 우선 탐색은 O(logN)
 * 3. 자료구조
 * - 너비 우선 탐색을 위한 큐
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

        if (S == G) System.out.println(0);
        else System.out.println(result == 0 ? "use the stairs" : result);

    }

    static int bfs(){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(S, 0));


        while (!q.isEmpty()) {
            //현재 층
            Node poll = q.poll();
            if (visited[poll.getFloor()]) continue;
            visited[poll.getFloor()] = true;

            if (poll.getFloor() == G) {
                return poll.getCount();
            }

            //내려갈 수 있다면
            if (poll.getFloor() - D >= 1 ) {
                q.add(new Node(poll.getFloor() - D, poll.getCount() + 1));
            }
            if(poll.getFloor() + U <= F ){
                q.add(new Node(poll.getFloor() + U, poll.getCount() + 1));
            }
        }

        return 0;
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
