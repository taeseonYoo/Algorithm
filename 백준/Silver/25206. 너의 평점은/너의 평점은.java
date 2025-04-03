import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double sum = 0.0;
        double h = 0.0;
        for(int i=0;i<20;i++){
            String line = sc.nextLine();
            String[] sp = line.split(" ");

            if (sp[2].equals("P")) {
                continue;
            }
            sum += Double.parseDouble(sp[1])*check(sp[2]);
            h += Double.parseDouble(sp[1]);
        }
        System.out.printf("%.6f", sum / h);
    }
    public static double check(String a) {
        if(a.equals("A+")) return 4.5;
        else if(a.equals("A0")) return 4.0;
        else if(a.equals("B+")) return 3.5;
        else if(a.equals("B0")) return 3.0;
        else if(a.equals("C+")) return 2.5;
        else if(a.equals("C0")) return 2.0;
        else if(a.equals("D+")) return 1.5;
        else if(a.equals("D0")) return 1.0;
        else return 0.0;
    }
}



