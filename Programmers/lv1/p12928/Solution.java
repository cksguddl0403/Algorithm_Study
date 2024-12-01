package p12928;

public class Solution {
    public int solution(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(12));
        System.out.println(solution.solution(5));
    }
}