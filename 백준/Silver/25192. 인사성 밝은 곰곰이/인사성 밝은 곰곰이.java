import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> st = new HashSet<>();

        int answer = 0;

        while (n-- > 0) {
            String name = br.readLine();
            if ("ENTER".equals(name)) {
                st.clear();
            }else{
                if (!st.contains(name)) {
                    answer++;
                    st.add(name);
                }
            }
        }
        System.out.println(answer);
    }


}