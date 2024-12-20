import java.util.*;


public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Map<String,Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();

            mp.put(name, mp.getOrDefault(name,0)+1);
        }



        int maxValue = 0;
        String title = "{";

        for (String name : mp.keySet()) {

            if (mp.get(name) > maxValue){
                maxValue = mp.get(name);
                title = name;
            }else if(mp.get(name)==maxValue){
                if( name.compareTo(title)<0){
                    maxValue = mp.get(name);
                    title = name;
                }
            }
        }
        System.out.println(title);




    }
}

