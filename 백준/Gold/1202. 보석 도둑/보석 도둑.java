import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 백준 1202
 * 1. 시간 복잡도
 * N과 K에 대하여 정렬을 해야하므로 O(NlogN) = 30만 * 18
 * 2. 공간 복잡도
 * 보석 가격의 합은 long 타입에 저장한다.
 * 보석의 정보를 담는 클래스
 * 보석 리스트, 및 가방 리스트 (<=30만)
 * 3. 아이디어
 * 가격이 높은 순서로, 가장 작은 가방에 넣어야한다.
 */
class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> jewels = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(weight, price));
        }

        jewels.sort(Comparator.comparingInt(Jewel::getWeight)
                .thenComparing(Jewel::getPrice,Comparator.reverseOrder()));

        ArrayList<Integer> bags = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            int weight = Integer.parseInt(br.readLine());
            bags.add(weight);
        }

        Collections.sort(bags);

        long result = 0;
        int j = 0;

        PriorityQueue<Integer> weightPQ = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < K; i++) {

            Integer bag = bags.get(i);

            while(j<N && jewels.get(j).weight<=bag){
                weightPQ.add(jewels.get(j++).price);
            }
            if (!weightPQ.isEmpty()) {
                result += weightPQ.poll();
            }
        }

        System.out.println(result);
    }

}

class Jewel{
     int weight;
     int price;

    public Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}
