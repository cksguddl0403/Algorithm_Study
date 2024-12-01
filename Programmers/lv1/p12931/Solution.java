package p12931;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n != 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(123));
        System.out.println(solution.solution(987));
    }
}