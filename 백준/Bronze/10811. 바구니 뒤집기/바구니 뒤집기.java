import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n,m;

        n = sc.nextInt();
        m = sc.nextInt();

        int[] bask = new int[n];

        for (int s = 0; s < n; s++) {
            bask[s]=s+1;
        }

        for (int k = 0; k < m; k++) {
            int i = sc.nextInt()-1;
            int j = sc.nextInt()-1;

            for (int l = i; l < (i+j+1)/2 ; l++) {
                int tmp = bask[l];
                bask[l] = bask[i + j  - l];
                bask[i  + j  - l] = tmp;
            }


        }

        for (int e = 0; e < n; e++) {
            System.out.print(bask[e]+" ");
        }




    }

}
