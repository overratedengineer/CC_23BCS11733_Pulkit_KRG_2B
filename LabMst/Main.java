import java.util.*;

public class Main {

    public static int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);

        int l = 0;
        int r = tokens.length - 1;
        int score = 0;
        int max = 0;

        while (l <= r) {

            if (power >= tokens[l]) {
                power = power - tokens[l];
                score = score + 1;
                l = l + 1;

                if (score > max) {
                    max = score;
                }
            } 
            else {
                if (score > 0) {
                    power = power + tokens[r];
                    score = score - 1;
                    r = r - 1;
                } 
                else {
                    break;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] tokens = {100, 200, 300, 400};
        int power = 200;

        int ans = bagOfTokensScore(tokens, power);

        System.out.println(ans);
    }
}