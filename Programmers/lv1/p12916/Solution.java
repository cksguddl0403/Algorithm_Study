package p12916;

public class Solution {

    public boolean solution(String s) {

        int pCount = 0;
        int yCount = 0;

        for (char c : s.toCharArray()) {
            if(c == 'p' || c == 'P') {
                pCount++;
            }else if(c == 'y' || c == 'Y') {
                yCount++;
            }
        }

        return pCount == yCount;

    }

/*

    boolean solution(String s) {

        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();

    }
*/

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("pPoooyY"));
        System.out.println(solution.solution("Pyy"));
    }
}