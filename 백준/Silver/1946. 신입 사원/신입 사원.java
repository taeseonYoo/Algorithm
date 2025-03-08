import java.util.*;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- >0){
            int n = sc.nextInt();
            int count = 0;
            List<Node> s = new ArrayList<>();

            while(n-- >0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                s.add(new Node(a,b));
            }

            Collections.sort(s);

            count++; //1등

            int min = s.get(0).b;

            for (int i = 1; i < s.size(); i++) {

                int m = s.get(i).b;

                if(m < min){
                    count++;
                    min = m;
                }
            }

            System.out.println(count);
        }
    }

}
class Node implements Comparable<Node>{
    int a;
    int b;

    public Node(int a,int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node o) {
        return this.a-o.a;
    }
}


