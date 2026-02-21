import java.util.Scanner;

public class work {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int N = scanner.nextInt();

        long[] window = new long[K];
        window[0] = 1;
        long sum = 1;

        for (int i = 1; i <= N; i++) {
            long current = sum;
            sum += current;
            if (i >= K) {
                sum -= window[i % K];
            }
            window[i % K] = current;
        }

        System.out.println(window[N % K]);

        scanner.close();
    }
}