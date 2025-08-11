class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        answer = (long)(count * (count+1))/2 * price;

        answer = money - answer;
        return answer < 0 ? -1*answer : 0;
    }
}