import java.util.*;

public class Main {

    public static long[] result;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        result = new long[n+1];

        result[0] = 0;
        result[1] = 1;

        for(int i=2;i<=n;i++){
            result[i] = result[i-1]+result[i-2];
        }

        System.out.println(result[n]);
    }

}


