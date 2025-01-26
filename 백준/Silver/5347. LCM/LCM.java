import java.util.*;

public class Main {


    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            long result = 0;
            if(a<b){
                result = lcm(b, a);
            }else{
                result = lcm(a, b);
            }
            System.out.println(result);
        }

    }
    //최대 공약수
    public static int gcd(int a,int b) {

        int tmp;
        while(b!=0){
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    public static long lcm(int a,int b){
        return (long) a * (b / gcd(a,b));
    }

}
