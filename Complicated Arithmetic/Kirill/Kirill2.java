// Judge solution; runs faster

import java.io.*;
import java.util.*;

public class Kirill2 {
    static final int MAXN = 5_000_000;

    public static int sumOfDigits(int x) {
        int ans = 0;
        while (x > 0) {
            ans += x % 10;
            x /= 10;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        // Precompute all the self numbers
        boolean[] isSelf = new boolean[MAXN + 1];
        Arrays.fill(isSelf, true);
        for (int i = 1; i <= MAXN; i++) {
            int nextValue = i + sumOfDigits(i);
            if (nextValue <= MAXN) {
                isSelf[nextValue] = false;
            }
        }

        // Store the answer for every possible input
        int[] ans = new int[MAXN + 1];
        int ptr = MAXN;
        while (!isSelf[ptr]) {
            --ptr;
        }

        for (int i = MAXN; i >= 1; --i) {
            if (ptr > i) {
                ptr = i;
            }
            while (!isSelf[ptr]) {
                --ptr;
            }
            ans[i] = ptr;
        }

        Scanner scan = new Scanner(new File("kirill.dat"));

        int T = scan.nextInt();
        assert 1 <= T && T <= 50;

        for (int caseNum = 1; caseNum <= T; caseNum++) {
            int n = scan.nextInt();

            assert 1 <= n && n <= MAXN;

            System.out.printf("Case #%d: %d%n", caseNum, ans[n]);
        }
    }
}
