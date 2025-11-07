import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main{
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> register = new HashSet<>();

        int n = getOptionCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String option = br.readLine();
            String[] splitWord = option.split(" ");
            //각 단어의 첫 글자가 등록되었는 지 확인한다.
            boolean isChanged = false;

            for (int j = 0; j < splitWord.length; j++) {
                char ch = splitWord[j].charAt(0);
                if (!register.contains(ch)) {
                    register.add(Character.toUpperCase(ch));
                    register.add(Character.toLowerCase(ch));
                    splitWord[j] = "[" + ch + "]" + splitWord[j].substring(1);
                    sb.append(String.join(" ", splitWord));
                    isChanged = true;
                    break;
                }
            }
            if (!isChanged) {
                for (int j = 0; j < option.length(); j++) {
                    char target = option.charAt(j);
                    if (target == ' ') continue;
                    if (!register.contains(target)) {
                        register.add(Character.toUpperCase(target));
                        register.add(Character.toLowerCase(target));
                        StringBuilder tmp = new StringBuilder(option);
                        tmp.insert(j,"[");
                        tmp.insert(j + 2, "]");
                        sb.append(tmp);
                        isChanged = true;
                        break;
                    }
                }
            }
            if (!isChanged) {
                sb.append(option);
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int getOptionCount() throws IOException {
        st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

}