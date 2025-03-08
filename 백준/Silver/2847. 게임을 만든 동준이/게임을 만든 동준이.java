import org.w3c.dom.Node;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            list.add(a);
        }

        int answer = 0;
        int before = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; i--) {

            if(list.get(i)>=before){
                int t = list.get(i) - before + 1;
                answer += t;
                before = before-1;
            }else{
                before = list.get(i);
            }


        }
        System.out.println(answer);
    }
}



