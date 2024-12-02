package p12932;

import java.util.Arrays;

public class Solution {

    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];

        int cnt = 0;
        while(n > 0) {
            answer[cnt] = (int) (n % 10);
            n /= 10;
            cnt++;
        }
        return answer;
    }

/*
    public int[] solution(long n) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        while(n != 0) {
            arrayList.add((int) (n % 10));
            n /= 10;
        }

        int[] answer = new int[arrayList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }
*/

/*

    public int[] solution(long n) {
        String str = String.valueOf(n);
        char[] s = str.toCharArray();
        int[] answer = new int[str.length()];
        for(int i=str.length()-1;i>=0;i--) {//뒤집어서 입력
            answer[str.length()-1-i] = str.charAt(i)-'0';
        }
        return answer;
    }
*/

/*

    public int[] solution(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }

*/

/*

    public int[] solution(long n) {

        String s = String.valueOf(n);

        int[] answer = new int[s.length()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(s.substring(answer.length-1-i, answer.length-i));
        }

        return answer;
    }
*/



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(12345)));
    }
}