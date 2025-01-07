import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> mp = new HashMap<>();

        int n = sc.nextInt();
        int c = sc.nextInt();

        List<Integer> num = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            num.add(a);
            mp.put(a ,mp.getOrDefault(a,0)+1);
        }

        List<Integer> list = new ArrayList<>(mp.keySet());



        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (mp.get(o1) < mp.get(o2)){
                    return 1;
                }else if(mp.get(o1) > mp.get(o2)){
                    return -1;
                }


                if(num.indexOf(o1) < num.indexOf(o2)){
                    return -1;
                }else {
                    return 1;
                }

            }
        });

        for (int i = 0; i < list.size(); i++) {
            int k = mp.get(list.get(i));
            for (int j = 0; j < k; j++) {
                System.out.print(list.get(i)+" ");
            }
        }







    }

}
