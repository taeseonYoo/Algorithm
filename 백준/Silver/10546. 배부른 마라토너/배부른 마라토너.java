import java.util.*;


public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        sc.nextLine();

        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();

            mp.put(name, mp.getOrDefault(name,0)+1);
        }

        for (int i = 0; i < n - 1; i++) {
            String name = sc.nextLine();
            mp.put(name,mp.get(name)-1);
            if (mp.get(name) == 0) {
                mp.remove(name);
            }
        }

        String answer = "";
        for (String s : mp.keySet()) {
            answer = s;
        }
        System.out.println(answer);



    }
}

